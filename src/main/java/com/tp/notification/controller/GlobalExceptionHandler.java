package com.tp.notification.controller;

import com.tp.notification.exception.NotificationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.Locale;

@ControllerAdvice
public class GlobalExceptionHandler {

    @Autowired
    MessageSource messageSource;

    @ExceptionHandler(NotificationException.class)
    public String notificationExceptionHandler(Exception e, Model model){

        model.addAttribute("message", e.getMessage());
        return "error";
    }

    @ExceptionHandler(Exception.class)
    public String defaultExceptionHandler(Exception e, Model model, Locale locale){
        String message = messageSource.getMessage("default.error", null, locale);
        model.addAttribute("message", message);
        return "error";
    }

}
