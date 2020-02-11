package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/css/**","/js/**","/fonts/**","/index").permitAll()//所有人都可以访问
                .antMatchers("/users/**").hasRole("ADMIN")//管理员可以访问users
                .and()
                .formLogin()//基于Form表单验证登录
                .loginPage("/login").failureUrl("/login-error");//登录成功与失败的页面
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()//认证信息存储在内存当中的
                .withUser("miaozheng").password("123456").roles("ADMIN");//初始化用户
    }
}
