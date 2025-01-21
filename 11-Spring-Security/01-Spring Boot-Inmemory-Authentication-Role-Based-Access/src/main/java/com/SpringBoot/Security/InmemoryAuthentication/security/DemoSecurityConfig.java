package com.SpringBoot.Security.InmemoryAuthentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig {

    // define In-memory user credential
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails steve = User.builder()
                .username("steve")
                .password("$2a$12$SpXe0DaLSyAFp60NNl3gp.A31wl790RZbD3eErbF1cG877v.WpQdG")
                .roles("USER")
                .build();

        UserDetails mark = User.builder()
                .username("mark")
                .password("$2a$12$SpXe0DaLSyAFp60NNl3gp.A31wl790RZbD3eErbF1cG877v.WpQdG")
                .roles("USER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(steve,mark);
    }

    // define role based access
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(
                registry -> registry
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/api/user/**").hasRole("USER")
                        .requestMatchers("/api/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).formLogin(form -> form.permitAll()).exceptionHandling(error->error.accessDeniedPage("/api/403-Access-Denied"));

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
