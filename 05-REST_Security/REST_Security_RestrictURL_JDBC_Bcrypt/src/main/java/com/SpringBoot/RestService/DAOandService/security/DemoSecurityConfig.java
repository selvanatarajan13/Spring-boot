package com.SpringBoot.RestService.DAOandService.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration // this annotation will help to setup the security config
public class DemoSecurityConfig {

    // create credential to logging on the site
//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails mahend = User.builder()
//                .username("mahendran@gmail.com")
//                .password("{noop}fun1234")
//                .roles("EMPLOYEE")
//                .build();
//
//        UserDetails SELVA = User.builder()
//                .username("selvanatarajan13@gmail.com")
//                .password("{noop}fun1234")
//                .roles("EMPLOYEE","MANAGER")
//                .build();
//
//        UserDetails John = User.builder()
//                .username("john@gmail.com")
//                .password("{noop}fun1234")
//                .roles("EMPLOYEE","MANAGER","ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(mahend,SELVA, John);
//
//    }




    // add JDBC support
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    // Restrict the CRUD operation based on URL restriction
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configure ->
            configure
                    .requestMatchers(HttpMethod.GET, "/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET, "/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.POST, "/api/employees").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasRole("ADMIN")
        );

        // use Http basic authendication
        httpSecurity.httpBasic(Customizer.withDefaults());

        // desible CSRF(Cross Site Request Forgery) token
        // In general, not required for stateless REST APIs that use POST, PUT, UPDATE, DELETE
        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();

    }

}
