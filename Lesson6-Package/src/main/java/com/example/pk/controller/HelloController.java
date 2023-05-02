package com.example.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {

    @Autowired
    private Date date;

    @GetMapping("/hello")
    public String hello() {
        return "歡迎使用 Spring Boot 3 !!" + date;
    }
}
