package com.way.springsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Way Liang
 * @Date: 11/18/2018 21:01
 * @Description:
 */
@EnableWebSecurity
public class WebSecurityConfig implements WebMvcConfigurer {

    /**
     * 最简单的一种，返回直接的用户名密码
     * @return
     */

    @Bean
    public UserDetailsService userDetailsService(){
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder().username("username").password("password").roles("USER").build());
        return manager;
    }












}
