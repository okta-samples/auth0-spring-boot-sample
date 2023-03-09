package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.logout.OidcClientInitiatedLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration {

    private final ClientRegistrationRepository clientRegistrationRepository;

    public SecurityConfiguration(ClientRegistrationRepository clientRegistrationRepository) {
        this.clientRegistrationRepository = clientRegistrationRepository;
    }

    OidcClientInitiatedLogoutSuccessHandler oidcLogoutSuccessHandler() {
        OidcClientInitiatedLogoutSuccessHandler successHandler =
            new OidcClientInitiatedLogoutSuccessHandler(clientRegistrationRepository);
        successHandler.setPostLogoutRedirectUri("http://localhost:8080/");
        return successHandler;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((requests) -> requests
            // allow anonymous access to the root page
            .requestMatchers("/").permitAll()
            // authenticate all other requests
            .anyRequest().authenticated());
        // configure logout success handler
        http.logout((logout) -> logout.logoutSuccessHandler(oidcLogoutSuccessHandler()));
        // enable OAuth2/OIDC
        http.oauth2Login();
        // enable Resource Server for API access
        http.oauth2ResourceServer().jwt();

        return http.build();
    }
}
