package com.example.pk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

/**
 * 核心註解功能
 * @SpringBootApplication：包含@Configuration註解的功能
 *    @Configuration：JavaConfig的功能，配置類，結合@Bean能夠將object注入到spring的IOC容器
 *    有@SpringBootApplication標註的類是配置類，Application是配置類
 *
 * @EnableAutoConfiguration：開啟自動配置，將spring和其第三方庫中的object創建好，注入到spring容器
 * 							避免寫xml，去掉樣例代碼，需要使用的object，由框架提供
 *
 * @ComponentScan：組件掃描器，<context:component-scan base-package="xxx包"/>
 * 				 掃描@Controller，@Service，@Repository，@Component註解，創建他們的object注入到容器
 * 				 spring boot約定：啟動類，作為掃描包的root(起點)，@ComponentScan掃描com.example.pk和它的子包中所有的類
 */
@SpringBootApplication
public class Application {

	@Bean
	public Date myDate() {
		return new Date();
	}

	public static void main(String[] args) {
		// SpringApplication.run(源(配置類)，從這裡加載Bean，找到Bean注入到spring容器, args)
		SpringApplication.run(Application.class, args);
	}

}
