package com.tp.notification.service;

import com.tp.notification.Settings;
import com.tp.notification.entity.PasswordResetToken;
import com.tp.notification.entity.Role;
import com.tp.notification.repository.PasswordResetTokenRepository;
import com.tp.notification.repository.UserRepository;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.nio.file.Files;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import com.tp.notification.entity.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordResetTokenRepository passwordResetTokenRepository;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    MessageSource messageSource;

    @Autowired
    FileService fileService;

    @Value("${hostname}")
    private String hostname;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user1 = userRepository.findByEmail(username);
        User user2 = userRepository.findByUsername(username);
        return user1 == null ? user2 : user1;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public boolean addUser(User user, Locale locale, Model model) throws Throwable {
        String username = user.getUsername();
        User user1 = userRepository.findByUsername(username);
        User user2 = userRepository.findByEmail(user.getEmail());
        if (user1 != null || user2 != null || username.equals("template") || username.equals("common")) {
            model.addAttribute("message", "userExists");
            return false;
        }
        user.setActive(false);
        user.setRoles(Collections.singleton(Role.USER));
        user.setActivationCode(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setDateOfCreation(new Date());
        userRepository.save(user);
        Files.createDirectories(fileService.setPath(user.getUsername()));
        try{
            String message = String.format(
                    messageSource.getMessage("registration.message", null, locale),
                    hostname,
                    user.getActivationCode()
            );
            sendMessage(user.getEmail(), "Регистрация на Notification", message);
        } catch (Exception e){
            userRepository.delete(user);
            FileUtils.deleteDirectory(fileService.setPath(user.getUsername()).toFile());
            model.addAttribute("message", "cannotSendEmail");
            return false;
        }
        return true;
    }

    private void sendMessage(String email, String subject, String message) {
        if (!StringUtils.isEmpty(email)){
            mailSender.send(email, subject, message);
        }
    }

    public boolean activateUser(String code) {
        User user = userRepository.findByActivationCode(code);
        if (user == null) {
            return false;
        }
        else {
            if(expired(user.getDateOfCreation(), Settings.EXPIRATION_OF_ACCOUNT_ACTIVATION_CODE)){
                userRepository.delete(user);
                return false;
            }
            else{
                user.setActivationCode(null);
                user.setActive(true);
                userRepository.save(user);
                return true;
            }
        }
    }

    public boolean expired(Date initialDate, int expirationPeriod){
        Calendar dateOfExpiration = Calendar.getInstance();
        dateOfExpiration.setTimeInMillis(initialDate.getTime());
        dateOfExpiration.add(Calendar.MINUTE, expirationPeriod);
        long expirationInSeconds = dateOfExpiration.getTime().getTime();
        return nowInSeconds() > expirationInSeconds;
    }

    private static long nowInSeconds(){
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(new Date().getTime());
        return now.getTime().getTime();
    }

    private static long dateInSeconds(Date date){
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTimeInMillis(date.getTime());
        return calendarDate.getTime().getTime();
    }

    public void saveUser(User user, User newUser, Map<String,String> form, String dateOfExpiration) throws ParseException {
        user.setUsername(newUser.getUsername());
        user.setActive(newUser.isActive());
        user.setApproved(newUser.isApproved());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        if(!dateOfExpiration.equals("")){
            date = sdf.parse(dateOfExpiration);
        }
        user.setExpiryDateOfApproval(date);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();
        for (String key : form.keySet()) {
            if (roles.contains(key)) {
                user.getRoles().add(Role.valueOf(key));
            }
        }
        userRepository.save(user);
    }

    public void updateProfile(User user, String firstName, String lastName,
                              String company, String email, String password1,
                              String password2) {

        boolean isFirstNameChanged = isFieldChanged(user.getFirstName(), firstName);
        if(isFirstNameChanged){
            user.setFirstName(firstName);
        }
        boolean isLastNameChanged = isFieldChanged(user.getLastName(), lastName);
        if(isLastNameChanged){
            user.setLastName(lastName);
        }
        boolean isCompanyChanged = isFieldChanged(user.getCompany(), company);
        if(isCompanyChanged){
            user.setCompany(company);
        }
        boolean isEmailChanged = isFieldChanged(user.getEmail(), email);
        if(isEmailChanged){
            if(userRepository.findByEmail(email) == null){
                user.setEmail(email);
            }
        }
        boolean password1MatchesOldPassword = passwordEncoder.matches(password1, user.getPassword());
        boolean password2MatchesOldPassword = passwordEncoder.matches(password2, user.getPassword());
        if(password1MatchesOldPassword && !password2MatchesOldPassword){
            user.setPassword(passwordEncoder.encode(password2));
        }
        if(isFirstNameChanged || isLastNameChanged || isCompanyChanged || isEmailChanged ||
                (password1MatchesOldPassword && !password2MatchesOldPassword)){
            userRepository.save(user);
        }
    }

    private boolean isFieldChanged(String userInContextField, String formField){
        return (formField != null && !formField.equals(userInContextField))
                || (userInContextField != null && !userInContextField.equals(formField));
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public void setUserInactive(String username) {
        User user = userRepository.findByUsername(username);
        user.setActive(false);
        userRepository.save(user);
    }

    @Scheduled(cron = "0 0 5 * * ?")
    public void expiredDatesHandling(){
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getActivationCode() != null &&
                    expired(user.getDateOfCreation(), Settings.EXPIRATION_OF_ACCOUNT_ACTIVATION_CODE)){
                userRepository.delete(user);
            }
            PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByUser(user);
            if(passwordResetToken != null &&
                    expired(passwordResetToken.getDateOfCreation(), Settings.EXPIRATION_OF_PASSWORD_RESET_TOKEN)){
                passwordResetTokenRepository.delete(passwordResetToken);
            }
            Date expiryDateOfApproval = user.getExpiryDateOfApproval();
            if(expiryDateOfApproval != null && nowInSeconds() > dateInSeconds(expiryDateOfApproval)){
                user.setApproved(false);
                user.setExpiryDateOfApproval(null);
                userRepository.save(user);
            }
        }
    }

    public String sendRequest(User user, Locale locale) throws Exception {
        String response;
        if(!user.isAskedForApproval()){
            String message = String.format(
                    messageSource.getMessage("approval.request.message", null, locale),
                    user.getUsername(),
                    user.getEmail()
            );
            user.setAskedForApproval(true);
            userRepository.save(user);
            try{
                sendMessage("tp.notification2021@gmail.com", "Request for Approval on Notification", message);
            } catch (Exception e){
                user.setAskedForApproval(false);
                userRepository.save(user);
                throw new Exception(e);
            }
            response = "requestHasBeenSent";
        }
        else if(user.isAskedForApproval() && !user.isApproved()){
            response = "requestIsBeingProcessed";
        }
        else {
            response = "yourAccountIsApproved";
        }
        return response;
    }

    public void deleteUser(User user) throws IOException {
        userRepository.delete(user);
        FileUtils.deleteDirectory(fileService.setPath(user.getUsername()).toFile());
    }

    public void sendEmailToResetPassword(String email, Locale locale, Model model) throws Exception {
        User user = userRepository.findByEmail(email);
        PasswordResetToken prt = passwordResetTokenRepository.findByUser(user);
        if(user == null || user.getActivationCode() != null){
            model.addAttribute("message", "userDoesNotExist");
            return;
        }
        if(prt == null){
            String token = UUID.randomUUID().toString();
            PasswordResetToken passwordResetToken = new PasswordResetToken();
            passwordResetToken.setToken(token);
            passwordResetToken.setUser(user);
            passwordResetToken.setDateOfCreation(new Date());
            passwordResetTokenRepository.save(passwordResetToken);
            try{
                String message = String.format(
                        messageSource.getMessage("password.reset.message", null, locale),
                        hostname,
                        token
                );
                sendMessage(user.getEmail(), "Восстановление пароля на Notification", message);
            } catch (Exception e){
                passwordResetTokenRepository.delete(passwordResetToken);
                model.addAttribute("message", "cannotSendEmail");
                return;
            }
            model.addAttribute("message", "emailSent");
        }
        else{
            model.addAttribute("message", "doubleRequestToResetPassword");
        }
    }

    public User findUserByToken(String token) {
        User user = null;
        PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(token);
        if(passwordResetToken != null){
            user = passwordResetToken.getUser();
        }
        return user;
    }

    @Transactional
    public void setNewPassword(User user, String password) {
        user.setPassword(passwordEncoder.encode(password));
        userRepository.save(user);
        PasswordResetToken prt = passwordResetTokenRepository.findByUser(user);
        if(prt != null){
            passwordResetTokenRepository.delete(prt);
        }
    }

    public PasswordResetToken findPasswordResetTokenByToken(String token){
        return passwordResetTokenRepository.findByToken(token);
    }

    public void deletePasswordResetTokenByToken(PasswordResetToken token){
        passwordResetTokenRepository.delete(token);
    }
}












