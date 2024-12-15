
package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .requestMatchers("/join_new", "/api/members", "/member_login", "/error_page").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/member_login")
            .loginProcessingUrl("/api/login_check")
            .defaultSuccessUrl("/board_list")
            .failureUrl("/member_login?error=true")
            .permitAll()
            .and()
            .logout()
            .logoutUrl("/api/logout")
            .logoutSuccessUrl("/member_login")
            .invalidateHttpSession(true)  // Session invalidation
            .clearAuthentication(true)   // Clear authentication data
            .permitAll()
            .and()
            .sessionManagement(session -> session
                .invalidSessionUrl("/session-expired") // Session expiration redirect
                .maximumSessions(10) // Increased max sessions for better multi-user support
                .maxSessionsPreventsLogin(false) // Allow new logins but expire old sessions
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
