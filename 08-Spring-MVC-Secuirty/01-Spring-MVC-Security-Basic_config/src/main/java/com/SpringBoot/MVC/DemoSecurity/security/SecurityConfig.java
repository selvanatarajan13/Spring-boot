package com.SpringBoot.MVC.DemoSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;


@Configuration
public class SecurityConfig {

    @Bean
    // define custom user credential
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails Steve = User.builder()
                .username("steve@gmail.com")
                .password("{noop}fun123")
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(Steve);

    }

}
