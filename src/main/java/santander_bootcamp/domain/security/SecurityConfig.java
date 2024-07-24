package santander_bootcamp.domain.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/h2-console/**").permitAll() // Permitir acesso ao console H2
                                .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // Desabilitar CSRF para permitir o uso do console H2
                .headers(headers ->
                        headers
                                .frameOptions().sameOrigin() // Permitir que o H2 seja carregado em um iframe
                );

        return http.build();
    }
}
