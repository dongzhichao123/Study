package com.example.usersecurity.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

/**
 * @author dong
 * @title: SecurityConfig
 * @projectName usersecurity
 * @description: TODO
 * @date 2022/3/22 0:08
 **/
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfiguration {
}
