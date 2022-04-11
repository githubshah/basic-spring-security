package com.shah.rest;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home(OAuth2AuthenticationToken object) {
        return "<h1>Welcome Home Secured</h1>";
    }

    @GetMapping("/redirect")
    public String redirect(OAuth2AuthenticationToken object) {
        System.out.println(object);
        return "<h1>Welcome Admin</h1>";
    }

}