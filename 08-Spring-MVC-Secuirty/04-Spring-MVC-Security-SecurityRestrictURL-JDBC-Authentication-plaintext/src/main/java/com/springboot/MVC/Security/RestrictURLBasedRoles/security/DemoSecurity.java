package com.springboot.MVC.Security.RestrictURLBasedRoles.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurity {

    // In Memory Authentication
    /*
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
     */


    // In memory Authentication using DefaultPasswordEncoder
    /* In the following sample, we use User.withDefaultPasswordEncoder to ensure that the password stored in memory is protected. */
    /*
    @Bean
    public UserDetailsManager user() {

        // The builder will ensure the passwords are encoded before saving memory
        User.UserBuilder userBuilder = User.withDefaultPasswordEncoder();
        UserDetails steve = userBuilder
                .username("steve")
                .password("fun1234")
                .roles("EMPLOYEE","MANAGER")
                .build();

        return new InMemoryUserDetailsManager(steve);
    }
    */

    // JDBC authentication and store password on plain text format

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    //

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
