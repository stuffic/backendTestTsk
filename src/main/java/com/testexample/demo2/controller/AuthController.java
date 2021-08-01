package com.testexample.demo2.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.testexample.demo2.AuthBean;

@CrossOrigin(origins={ "*" })
@RestController
public class AuthController implements WebMvcConfigurer {

    @GetMapping(path = "/basicauth")
    public AuthBean authenticate() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new AuthBean("You are authenticated");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
}