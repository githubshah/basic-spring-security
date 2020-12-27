package com.shah.springsecurity.jwt.service;

import com.shah.springsecurity.jwt.repo.MyUserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ExtUserDetailService implements UserDetailsService {

    @Autowired
    private MyUserDetailRepository myUserDetailRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new MyUserDetails(myUserDetailRepository.getUserByName(s));
    }

}