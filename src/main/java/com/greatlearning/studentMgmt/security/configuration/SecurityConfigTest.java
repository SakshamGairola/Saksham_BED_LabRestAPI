package com.greatlearning.studentMgmt.security.configuration;

import com.greatlearning.studentMgmt.security.serviceImpl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigTest {

    @Bean
    public UserDetailsService getUserDetailsService(){
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider getAuthenticationProvider(){
        var authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(getUserDetailsService());
        authenticationProvider.setPasswordEncoder(getPasswordEncoder());
        return authenticationProvider;
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder authManager) throws Exception {
//        authManager.authenticationProvider(getAuthenticationProvider());
//    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .cors().disable()
                .authorizeHttpRequests((requests) ->
                        requests
                                .requestMatchers("/","/create/*", "/view/*")
                                .hasAnyAuthority("ADMIN", "USER")
                                .requestMatchers("/edit/*","/delete/*")
                                .hasAuthority("ADMIN")
                                .anyRequest().authenticated())

                .formLogin((form) ->
                        form
                                .successForwardUrl("/")
                                .permitAll())
                .logout((logout) ->
                        logout
                                .logoutSuccessUrl("/login")
                                .permitAll())
                .exceptionHandling().accessDeniedPage("/error/403");
//                .antMatchers("/","/create/*", "/view/*").hasAnyAuthority("ADMIN", "USER")
//                .antMatchers("/edit/*","/delete/*").hasAuthority("ADMIN")
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginProcessingUrl("/login").successForwardUrl("/").permitAll()
//                .and()
//                .logout().logoutSuccessUrl("/login").permitAll()
//                .and()
//                .exceptionHandling().accessDeniedPage("/error/403")
//                .and()
//                .cors().and().csrf().disable();
        return http.build();
    }
}
