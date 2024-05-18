package com.example.oauth_2.controller;

import com.example.oauth_2.config.UserEventLogger;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    private final UserEventLogger userEventLogger;

    @Autowired
    public LogoutController(UserEventLogger userEventLogger) {
        this.userEventLogger = userEventLogger;
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName();
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            userEventLogger.logLogout(username);
        }
        return "redirect:/login?logout";
    }
}