package com.example.demo;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class HomeController {
    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    ModelAndView userDetails(OAuth2AuthenticationToken authentication) {
        return new ModelAndView("profile", Collections.singletonMap("details", authentication.getPrincipal().getAttributes()));
    }
}
