package com.brunoandrade.fiadosafe.infra.security;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@SecurityScheme(
        name = SecurityConfigurations.SECURITY,
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
@SecurityRequirement(name = SecurityConfigurations.SECURITY)
public class SecurityConfigurations {

    public static final String SECURITY = "bearerAuth";
    private final SecurityFilter securityFilter;

    @Autowired
    public SecurityConfigurations(SecurityFilter securityFilter) {
        this.securityFilter = securityFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests (authorizeRequests -> authorizeRequests
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/client").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/client").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/purchase").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/purchase").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/purchase").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/purchase").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/purchase").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/payment").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/api/payment").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/api/payment").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/payment").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/payment").hasRole("ADMIN")
                        .requestMatchers("/v3/api-docs/**", "swagger-ui/**","swagger-ui.html").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exceptionHandling ->
                        exceptionHandling.authenticationEntryPoint(unauthorizedEntryPoint())
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationEntryPoint unauthorizedEntryPoint() {
        return new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED);
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
