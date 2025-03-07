package com.SpringBoot.MVC.Security.CustomTableAuthentication.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class DemoSecurity {

    @Bean
    // custom table uses to retrieve the username, password and roles
    public UserDetailsManager userDetailsManager(DataSource dataSource) throws Exception {
        JdbcUserDetailsManager theUser = new JdbcUserDetailsManager(dataSource);

        // define a query to retrieve a user by username
        theUser.setUsersByUsernameQuery(
                "select username, password, enabled from members where username = ?"
        );

        // define a query to retrieve a roles by username
        theUser.setAuthoritiesByUsernameQuery(
                "select username, authority from roles where username = ?"
        );

        return theUser;
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(form ->
                form
                        .anyRequest().authenticated()
        ).formLogin( form ->
                form
                        .loginPage("/login")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll()

        ).logout(ll -> ll.permitAll());

        return httpSecurity.build();
    }
}
