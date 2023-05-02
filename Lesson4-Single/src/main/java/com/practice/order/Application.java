package com.practice.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 啟動類：有 @SpringBootApplication註解的class是啟動類(入口類)
// 啟動類在root包下面(推薦)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
