package com.example.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.example.mybatis.mapper")
@SpringBootApplication
public class Lesson10MyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson10MyBatisApplication.class, args);
	}

}
