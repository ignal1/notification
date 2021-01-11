package com.tp.notification.controller;

import com.tp.notification.Settings;
import com.tp.notification.entity.PasswordResetToken;
import com.tp.notification.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.Locale;
import java.util.Map;


import com.tp.notification.entity.User;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class PublicDataController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String greeting() {
        return "welcome";
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@Valid User user, BindingResult bindingResult, Model model, Locale locale) throws Throwable {

        if(bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "registration";
        }
        else{
            if (!userService.addUser(user, locale, model)) {
                return "registration";
            }
            model.addAttribute("message", "emailSent");
            return "/login";
        }
    }

    @GetMapping("/activate/{code}")
    public String activate(Model model, @PathVariable String code) {
        boolean isActivated = userService.activateUser(code);
        if (isActivated) {
            model.addAttribute("message", "successRegistration");
        } else {
            model.addAttribute("message", "codeIsMissing");
        }
        return "login";
    }

    @GetMapping("/resetPassword")
    public String forgotPassword(){
        return "resetPassword";
    }

    @PostMapping("/resetPassword")
    public String forgotPasswordPost(String email, Model model, Locale locale) throws Throwable {
        userService.sendEmailToResetPassword(email, locale, model);
        return "/resetPassword";
    }

    @GetMapping("/resetPassword/{token}")
    public String newPassword(Model model, @PathVariable String token) {
        User user = userService.findUserByToken(token);
        PasswordResetToken passwordResetToken = userService.findPasswordResetTokenByToken(token);
        if(user != null && passwordResetToken != null &&
                !userService.expired(passwordResetToken.getDateOfCreation(), Settings.EXPIRATION_OF_PASSWORD_RESET_TOKEN)){
            model.addAttribute("user", user);
            return "newPassword";
        }
        model.addAttribute("message", "cannotResetPassword");
        if(passwordResetToken != null){
            userService.deletePasswordResetTokenByToken(passwordResetToken);
        }
        return "login";
    }

    @PostMapping("/newPassword")
    public String newPasswordPost(@RequestParam("userId") User user, @RequestParam String password, Model model) {

        if(password == null || password.equals("")){
            model.addAttribute("user", user);
            model.addAttribute("blankPassword", "Поле не может быть пустым");
            return "newPassword";
        }
        else{
            userService.setNewPassword(user, password);
            model.addAttribute("message", "passwordHasBeenChanged");
            return "login";
        }
    }

}
