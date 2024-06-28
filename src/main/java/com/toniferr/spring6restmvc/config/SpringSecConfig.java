package com.toniferr.spring6restmvc.config;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Created by toniferr.
 */
@Profile("!test") //esta config no se recoge si perfil test está activo
@Configuration
public class SpringSecConfig {

//    Desactiva csrf y aque por defecto viene habilitada. De esta forma da igual que pongas user/pass
//    siempre autenticará. Para ello hay que poner authorizeHttpRequests()
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.csrf(httpSecurityCsrfConfigurer -> {
//          httpSecurityCsrfConfigurer.ignoringRequestMatchers("/api/**");
//        });
//        return httpSecurity.build();
//    }
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http.authorizeHttpRequests()
//                 .anyRequest().authenticated()
//                 .and().httpBasic(Customizer.withDefaults())
//                 .csrf.ignoringRequestMatchers("/api/**");
//        return httpSecurity.build();
//    }

    @Bean
    @Order(1)
    public SecurityFilterChain actuatorSecurityFilterChain(HttpSecurity http) throws Exception {
        //para los endpoint de actuator
        http.securityMatcher(EndpointRequest.toAnyEndpoint())
                .authorizeHttpRequests(authorize -> authorize.anyRequest().permitAll());
        return http.build();
    }

    @Bean
    @Order(2)
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(authorize -> {
                    authorize.requestMatchers("/v3/api-docs**", "/swagger-ui/**",  "/swagger-ui.html").permitAll()
                      .anyRequest().authenticated();
                })
               .oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> {
                     httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults());
                });

        return http.build();
    }

}
