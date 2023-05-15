package com.example.sample.controller;

import com.example.sample.service.OktaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
public class OktaController {
    @Autowired
    private OktaService service;
    @GetMapping("/")
    String home() {
        return "home";
    }

    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('SCOPE_profile')")
    ModelAndView userDetails(OAuth2AuthenticationToken authentication) {
        service.addTask(authentication);
        System.out.print(authentication.getPrincipal().getAttributes());
        return new ModelAndView("userProfile", Collections.singletonMap("details", authentication.getPrincipal().getAttributes()));
    }
        @GetMapping("/hello")
        String sayHello(@AuthenticationPrincipal Jwt jwt) {
            return String.format("Hello, %s!", jwt.getSubject());
        }

}
