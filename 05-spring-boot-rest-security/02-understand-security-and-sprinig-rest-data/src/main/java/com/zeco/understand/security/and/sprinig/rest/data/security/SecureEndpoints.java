package com.zeco.understand.security.and.sprinig.rest.data.security;

/*
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecureEndpoints {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configurer -> {
            configurer.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN"); }

        );

        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable cross site request forgery(csrf)
        //in general, not required for stateless REST APIs that use POST,PUT,DELETE and/or PATCH
        http.csrf( csrf -> csrf.disable());
        return http.build();

    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery( " select user_id,pw,active from members where user_id=?");

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");

        return  jdbcUserDetailsManager;
    }


}
*/



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

@Configuration
public class SecureEndpoints {



    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests( configurer -> {
            configurer.requestMatchers(HttpMethod.GET,"/api/employees12").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.GET,"/api/employees12/**").hasRole("EMPLOYEE")
                    .requestMatchers(HttpMethod.POST,"/api/employees12").hasRole("MANAGER")
                    .requestMatchers(HttpMethod.PUT,"/api/employees12").hasRole("MANGER")
                    .requestMatchers(HttpMethod.DELETE,"/api/employees12/**").hasRole("ADMIN"); }

        );

        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable cross site request forgery(csrf)
        //in general, not required for stateless REST APIs that use POST,PUT,DELETE and/or PATCH
        http.csrf( csrf -> csrf.disable());
        return http.build();

    }




    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        //define query to retrieve a user by username
        jdbcUserDetailsManager.setUsersByUsernameQuery( " select user_id,pw,active from members where user_id=?");

        //define query to retrieve the authorities/roles by username
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id,role from roles where user_id = ?");

        return  jdbcUserDetailsManager;
    }

}
