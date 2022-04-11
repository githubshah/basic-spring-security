package com.shah.springsecurity.jwt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and()
                .oauth2Login();
    }

    @Bean
    public OAuth2AuthorizedClientService authorizedClientService() {
        return new InMemoryOAuth2AuthorizedClientService(
                clientRegistrationRepository());
    }

    @Bean
    ClientRegistrationRepository clientRegistrationRepository() {
        ClientRegistration google = CommonOAuth2Provider.GOOGLE.getBuilder("google")
                .clientId("171111768645-p9nkt4fgmb4qth918e4tpnh9pfvdq5vu.apps.googleusercontent.com")
                .clientSecret("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")
                .build();
        return new InMemoryClientRegistrationRepository(google);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
