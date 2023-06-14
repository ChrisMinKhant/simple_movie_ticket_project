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
                                /*
                                 * This authorization configuration is for users endpoints.
                                 */
                                config -> config
                                                .requestMatchers(HttpMethod.POST, "/api/users").permitAll()
                                                .requestMatchers(HttpMethod.GET, "/api/users/{email}")
                                                .hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/users").hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/users").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/users/{email}")
                                                .hasRole("MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for tickets endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/tickets/{id}")
                                                .hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/tickets").hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/tickets/{id}")
                                                .hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/tickets").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/tickets/{id}").hasRole(
                                                                "MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for theaters endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/theaters/{id}")
                                                .hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/theaters").hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/theaters").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/theaters").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/theaters/{id}").hasRole(
                                                                "MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for movies endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/movies/{id}")
                                                .hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/movies").hasRole("NORMALUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/movies").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/movies").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/movies/{id}").hasRole(
                                                                "MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for show-times endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/show-times/{id}")
                                                .hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/show-times").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/show-times").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/show-times")
                                                .hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/show-times/{id}").hasRole(
                                                                "MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for prices endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/prices/{id}")
                                                .hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/prices").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.PUT, "/api/prices").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/prices").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/prices/{id}").hasRole(
                                                                "MANAGABLEUSER")

                                                /*
                                                 * This authorization configuration is for roles endpoints.
                                                 */
                                                .requestMatchers(HttpMethod.GET, "/api/roles/{id}").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.GET, "/api/roles").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.POST, "/api/roles").hasRole("ADMINUSER")
                                                .requestMatchers(HttpMethod.DELETE, "/api/roles/{id}")
                                                .hasRole("MANAGABLEUSER"))
                                .passwordManagement(Customizer.withDefaults());

                // Disable csrf for development process;
                httpSecurity.csrf().disable();

                // Adding on all basci HTTP securities.
                httpSecurity.httpBasic(Customizer.withDefaults());

                return httpSecurity.build();
        }
}
