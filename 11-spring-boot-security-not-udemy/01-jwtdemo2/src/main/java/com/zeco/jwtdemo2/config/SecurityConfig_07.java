package com.zeco.jwtdemo2.config;


import com.zeco.jwtdemo2.filter.JwtAuthenticationFilter_06;
import com.zeco.jwtdemo2.service.UserDetailsServiceImpl_05;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig_07 {

    private final JwtAuthenticationFilter_06 jwtAuthenticationFilter;
    private final UserDetailsServiceImpl_05 userDetailsServiceImpl;
    //private final CustomLogoutHandler logoutHandler;

    public SecurityConfig_07(JwtAuthenticationFilter_06 jwtAuthenticationFilter, UserDetailsServiceImpl_05 userDetailsServiceImpl) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
           return http.
                csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests( req -> req
                        .requestMatchers("/login/**","/register/**","/refreshToken")
                        .permitAll()
                        .requestMatchers("/admin").hasAuthority("2")
                        .anyRequest()
                        .authenticated()
                ).userDetailsService(userDetailsServiceImpl)
                .sessionManagement( session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                ).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }


}
