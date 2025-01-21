package com.springboot.MVC.Security.RestrictURLBasedRoles.security;

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
                .roles("EMPLOYEE")
                .build();

        UserDetails mark = User.builder()
                .username("mark")
                .password("{noop}fun123")
                .roles("EMPLOYEE","MANAGER")
                .build();

        UserDetails elon = User.builder()
                .username("elon")
                .password("{noop}fun123")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(steve,mark,elon);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasRole("EMPLOYEE")
                        .requestMatchers("/manager/**").hasRole("MANAGER")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(form ->
                form.loginPage("/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .permitAll()
        ).logout(demo -> demo.permitAll()).exceptionHandling(error -> error.accessDeniedPage("/403-Access-Denied"));

        return httpSecurity.build();
    }
}
