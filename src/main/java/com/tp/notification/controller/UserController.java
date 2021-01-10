package com.tp.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Locale;
import java.util.Map;
import com.tp.notification.service.UserService;
import com.tp.notification.entity.User;
import com.tp.notification.entity.Role;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roleAdmin", Role.ADMIN);
        return "userList";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public String userSave(
            @RequestParam("userId") User user,
            @RequestParam("dateOfExpiration") String dateOfExpiration,
            @ModelAttribute User newUser,
            @RequestParam Map<String, String> form,
            RedirectAttributes redirectAttributes) throws ParseException {
        User tmpUser = userService.findByUsername(newUser.getUsername());
        if (tmpUser != null && (tmpUser != user)) {
            String message = "User with " + tmpUser.getUsername() + " username exists!";
            redirectAttributes.addFlashAttribute("message", message);
            Long userId = user.getId();
            return "redirect:/user/" + userId.toString();
        }
        userService.saveUser(user, newUser, form, dateOfExpiration);
        return "redirect:/user";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("{user}/delete")
    public String userDelete(@PathVariable User user) throws IOException {
        if(!user.getRoles().contains(Role.ADMIN)){
            userService.deleteUser(user);
        }
        return "redirect:/user";
    }

    @GetMapping("profile")
    public String profile(@AuthenticationPrincipal User user, Model model) {

        ControllerUtils.userFieldsToModel(model, user);

        return "profile";
    }

    @GetMapping("fileList")
    public String files(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "fileList";
    }

    @GetMapping("deleteUser")
    public String deleteUser() {
        return "deleteUser";
    }

    @PostMapping("deleteUser")
    public String deleteUserPost(@AuthenticationPrincipal User user, HttpServletRequest request) {
        String username = user.getUsername();
        new SecurityContextLogoutHandler().logout(request, null, null);
        userService.setUserInactive(username);
        return "redirect:/";
    }

    @GetMapping("update")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {

        ControllerUtils.userFieldsToModel(model, user);

        return "editProfile";
    }

    @PostMapping("update")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String first_name,
            @RequestParam String last_name,
            @RequestParam String company,
            @RequestParam String email,
            @RequestParam String password1,
            @RequestParam String password2
    ) {
        userService.updateProfile(user, first_name, last_name, company, email, password1, password2);
        return "redirect:/user/profile";
    }

    @PostMapping("/approvalRequest")
    public ModelAndView sendRequest(@AuthenticationPrincipal User user,
                                    ModelAndView mav,
                                    RedirectAttributes redirectAttributes,
                                    Locale locale,
                                    Model model) throws Exception {
        String message = userService.sendRequest(user, locale);
        redirectAttributes.addFlashAttribute("message", message);
        mav.setViewName("redirect:/user/profile");
        return mav;
    }
}
