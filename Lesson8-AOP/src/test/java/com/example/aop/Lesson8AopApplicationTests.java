package com.example.aop;

import com.example.aop.service.SomeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Lesson8AopApplicationTests {

	@Autowired
	SomeService someService;

	@Test
	void testLog() {
		someService.query(1001);
		System.out.println("-----------");
		someService.save("Lisa", 26);
	}

}
