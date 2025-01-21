package com.SpringBoot.MVC.SecurityCustom.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurity {

    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails steve = User.builder()
                .username("steve")
                .password("{noop}fun123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(steve);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.formLogin(form -> form
                .loginPage("/showLoginPage")
                .loginProcessingUrl("/authenticateTheUser")
                .permitAll()
        ).authorizeHttpRequests( form -> form
                .anyRequest()
                .authenticated()
        ).logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }
}
