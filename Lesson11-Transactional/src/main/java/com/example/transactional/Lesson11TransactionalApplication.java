package com.example.transactional;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// 可選
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.transactional.mapper")
@SpringBootApplication
public class Lesson11TransactionalApplication {

	public static void main(String[] args) {
		SpringApplication.run(Lesson11TransactionalApplication.class, args);
	}

}
