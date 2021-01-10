package com.tp.notification.controller;

import com.tp.notification.Settings;
import com.tp.notification.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping
public class CommonController {

    @Autowired
    FileService fileService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("settings")
    public String settings(Model model) {
        model.addAttribute("limitation", Settings.limitation_is_on);
        return "settings";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("settings")
    public String settingsPost(@RequestParam Map<String, String> form) {
        ControllerUtils.appSettings(form);
        return "redirect:/";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("uploadOldTemplate")
    public String uploadOldTemplate(Model model) throws IOException {
        List<String> list = fileService.listOfFilesInDirectory("template_old");
        model.addAttribute("list", list);
        return "uploadOldTemplate";
    }

    @GetMapping("pages/page1")
    public String workWithService() {
        return "page1";
    }

    @GetMapping("pages/page2")
    public String templateEditRules() {
        return "page2";
    }

    @GetMapping("pages/page3")
    public String notificationFormat() {
        return "page3";
    }

    @GetMapping("pages/page4")
    public String notificationFillingRules() {
        return "page4";
    }

    @GetMapping("pages/page5")
    public String transferPricing() {
        return "page5";
    }

    @GetMapping("pages/page6")
    public String links() {
        return "page6";
    }


}
