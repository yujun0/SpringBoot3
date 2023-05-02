package com.example.web.model;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer age;
    private Role role;
}
