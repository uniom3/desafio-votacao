package com.mendonca.desafio_votacao.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http.csrf(csrf -> csrf.disable())
		 .authorizeHttpRequests(authz -> {authz

				.requestMatchers("/").permitAll();
				authz.requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/h2-console/**").permitAll();
				authz.requestMatchers(HttpMethod.GET,"/votos").permitAll();
				authz.requestMatchers(HttpMethod.POST,"/votos/**").permitAll();
				authz.requestMatchers(HttpMethod.GET,"/votacoes").permitAll();
				authz.requestMatchers(HttpMethod.POST,"/votacoes/**").permitAll();
				authz.requestMatchers(HttpMethod.GET,"/pautas").permitAll();
				authz.requestMatchers(HttpMethod.GET,"/pautas").permitAll();
				authz.anyRequest().permitAll()
				
				})
		 .build();
		.httpBasic().disable();
		
		//return http.build();
	}*/
	
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/**", "/h2-console/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/pautas").permitAll()
                .requestMatchers(HttpMethod.POST, "/pautas").permitAll()
                .requestMatchers(HttpMethod.POST, "/pautas").permitAll()
                .requestMatchers(HttpMethod.GET, "/votos").permitAll()
                .requestMatchers(HttpMethod.POST, "/votos/**").permitAll()
                .requestMatchers(HttpMethod.GET, "/votacaos").permitAll()
                .requestMatchers(HttpMethod.POST, "/votacaos/**").permitAll()
                .anyRequest().permitAll()
            )
            .httpBasic(httpBasic -> httpBasic.disable())
            .formLogin(formLogin -> formLogin.disable())
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()));
        
        return http.build();
    }

}
