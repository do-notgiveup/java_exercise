package com.example.demo_spring_security.config;

import com.example.demo_spring_security.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    @Lazy
    private AccountService accountService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth ->
                        auth.requestMatchers("/home","/register","/saveUser").permitAll()
                        .requestMatchers("/welcome").authenticated()
                        .requestMatchers("/admin").hasAuthority("Admin")
                        .requestMatchers("/mgr").hasAuthority("Manager")
                        .requestMatchers("/emp").hasAuthority("Employee")
                        .requestMatchers("/hr").hasAuthority("HR")
                        .requestMatchers("/common").hasAnyAuthority("Employeee,Manager,Admin")
                                .anyRequest().authenticated())
                .formLogin(form -> form.defaultSuccessUrl("/welcome"))
                .logout(lgo -> lgo.logoutRequestMatcher(new AntPathRequestMatcher("/logout")))
                .exceptionHandling(ex -> ex.accessDeniedPage("/access-denied"))
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(accountService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
