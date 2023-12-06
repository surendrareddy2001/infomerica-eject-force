//package com.infomerica.infomericaejectforce.Services;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfigurationGoogle extends WebSecurityConfigurerAdapter {
//
// @Override
// protected void configure(HttpSecurity http) throws Exception {
//     http
//         .authorizeRequests()
//             .antMatchers("/", "/welcome").permitAll()
//             .anyRequest().authenticated()
//             .and()
//         .oauth2Login()
//             .loginPage("/login")
//             .defaultSuccessURL("/login/google/callback") 
//             .and()
//         .logout()
//             .logoutSuccessUrl("/");
// }
//}
