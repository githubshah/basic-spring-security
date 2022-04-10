package com.shah.springsecurity.jwt.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExtUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("shah", "$2a$12$5okRLgFV7ILqVrXvrm6PNubo.6yYzBG3oPWVq5nAmBSNRldhuD6Nu", new ArrayList<>());
        //return new User("shah", "shah", new ArrayList<>());
        //https://bcrypt-generator.com/
    }

}
