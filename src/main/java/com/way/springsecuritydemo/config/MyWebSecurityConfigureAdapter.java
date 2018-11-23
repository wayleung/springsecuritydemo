package com.way.springsecuritydemo.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @Auther: Way Liang
 * @Date: 11/18/2018 22:41
 * @Description:
 */
@Component
public class MyWebSecurityConfigureAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().authenticated()
                .and().formLogin().and().httpBasic();

//        http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();


        http.logout().logoutUrl("/test/admin/admin/logout")
                .logoutSuccessUrl("/my/index")
//                .addLogoutHandler(logoutSuccessHandler)
                .invalidateHttpSession(true);
    }





}
