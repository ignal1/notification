package com.tp.notification.controller;

import com.tp.notification.Settings;
import com.tp.notification.entity.User;
import org.apache.commons.text.StringEscapeUtils;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ControllerUtils {

    static Model userFieldsToModel(Model model, User user){
        model.addAttribute("username", StringEscapeUtils.escapeHtml4(user.getUsername()));
        model.addAttribute("firstName", StringEscapeUtils.escapeHtml4(user.getFirstName()));
        model.addAttribute("lastName", StringEscapeUtils.escapeHtml4(user.getLastName()));
        model.addAttribute("company", StringEscapeUtils.escapeHtml4(user.getCompany()));
        model.addAttribute("email", StringEscapeUtils.escapeHtml4(user.getEmail()));
        model.addAttribute("approved", user.isApproved());
        return model;
    }

    static Map<String, String> getErrors(BindingResult bindingResult) {
        Collector<FieldError, ?, Map<String, String>> collector = Collectors.toMap(
                key -> key.getField() + "Error",
                value -> value.getDefaultMessage()
        );
        return bindingResult.getFieldErrors().stream().collect(collector);
    }

    static void appSettings(Map<String, String> form){
        Settings.limitation_is_on = false;
        for(String item : form.keySet()){
            if(item.equals("limitation")){
                Settings.limitation_is_on = true;
            }
        }
    }

}


