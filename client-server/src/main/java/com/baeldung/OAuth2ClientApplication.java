package com.baeldung;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//https://www.baeldung.com/spring-security-oauth-auth-server
//https://github.com/Baeldung/spring-security-oauth/blob/master/oauth-authorization-server/README.md

//http://127.0.0.1:8080/articles
@SpringBootApplication
public class OAuth2ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2ClientApplication.class, args);
    }

}