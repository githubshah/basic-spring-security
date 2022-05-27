package com.shah.springsecurity.jwt.config.provider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("customUserNamePasswordSecurityProvider")
public class UserAuthenticationProviderImpl implements AuthenticationProvider {

    Map<String, User> userMap = new HashMap<>();

    public UserAuthenticationProviderImpl() {
        userMap.put("u1", new User("u1", "p1", Arrays.asList(new SimpleGrantedAuthority("read"))));
        userMap.put("u2", new User("u2", "p2", Arrays.asList(new SimpleGrantedAuthority("read"))));
        userMap.put("u3", new User("u3", "p3", Arrays.asList(new SimpleGrantedAuthority("read"))));
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String pwd = authentication.getCredentials().toString();
        User user = userMap.get(name);
        if (user == null || !user.getPassword().endsWith(pwd)) {
            throw new BadCredentialsException("Invalid user");
        }
        final List<GrantedAuthority> grantedAuths = new ArrayList<>();
        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
        final UserDetails userDetails = new User(name, pwd, grantedAuths);
        final Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, "p1", grantedAuths);
        return auth;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}

