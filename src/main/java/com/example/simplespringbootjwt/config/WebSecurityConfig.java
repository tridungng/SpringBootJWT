package com.example.simplespringbootjwt.config;

import com.example.simplespringbootjwt.service.JwtTokenFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
public class WebSecurityConfig {

    public final JwtTokenFilter jwtAuthFilter;
    public final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeHttpRequests(
            authorize -> {
                try {
                    authorize.requestMatchers("/hello").authenticated()
                        .requestMatchers("/authenticate").permitAll()
                        .anyRequest().permitAll().and().sessionManagement()
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                        .and()
                        .authenticationProvider(authenticationProvider)
                        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
                    ;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

        return http.build();
    }
}
