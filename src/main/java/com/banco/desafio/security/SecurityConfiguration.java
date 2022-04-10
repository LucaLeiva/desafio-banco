package com.banco.desafio.security;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private final UserDetailsService userDetailsService;
    //@Autowired
    //private final DataSource dataSource;



    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {

        // este es el patron de diseño builder, que Lombok tambien lo tiene para hacer mas legibles las instanciaciones
        httpSecurity
                .authorizeRequests() // aca le digo que todas las requests que vengan a la api sean autorizadas
                .anyRequest() // no le importa cual request
                .authenticated() // seran autenticadas
                .and()
                .csrf().disable() // cross side request forgery, es un ataque que falsifica una peticion a un servidor web haciendose pasar por un usuario de confianza, se desabilita por ahora, se debe activar en produccion
                .httpBasic(); // aca se le indica la estrategia de autenticacion basica http
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(authenticationProvider());
                //.userDetailsService(userDetailsService)
                //.passwordEncoder(encoder())
                //.and()
                //.authenticationProvider(authenticationProvider())
                //.jdbcAuthentication()
                //.dataSource(dataSource);
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    // ahora Spring Security necesita saber de que forma hacer la autenticacion, ya que recibira usuarios y contraseñas,
    // pero, que hace con eso? este bean se configura para que sepa que servicio usar para autenticar a los usuarios

}