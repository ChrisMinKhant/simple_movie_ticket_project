package com.simple_movie_ticket_project.simple_movie_ticket_project.Config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource datasource) {

        JdbcUserDetailsManager userDetail = new JdbcUserDetailsManager(datasource);

        // Configuring query to retrive authentication data according to user's email.
        userDetail.setUsersByUsernameQuery("select email, password, enabled from users where email=?");

        // Configuring query to retrive authorization data according to user's email.
        userDetail.setAuthoritiesByUsernameQuery("select email, role from roles where email=?");

        return userDetail;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        // Configuring authorization base on roles.
        httpSecurity.authorizeHttpRequests(
                config -> config.requestMatchers(HttpMethod.GET, "/api/users/{email}").hasRole("NORMALUSER")
                        .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("NORMALUSER")
                        .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMINUSER")
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("ADMINUSER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/{email}").hasRole("MANAGABLEUSER"));

        // Disable csrf for development process;
        httpSecurity.csrf().disable();

        // Adding on all basci HTTP securities.
        httpSecurity.httpBasic(Customizer.withDefaults());

        return httpSecurity.build();
    }
}
