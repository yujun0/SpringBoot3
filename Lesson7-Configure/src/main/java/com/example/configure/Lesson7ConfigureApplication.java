package com.example.configure;

import com.example.configure.pk10.Person;
import com.example.configure.pk6.NestAppBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

// 啟用ConfigurationProperties，屬性是類的名字
//@EnableConfigurationProperties(NestAppBean.class)

// 掃描注解的package，其中綁定Bean注入到Spring容器
@ConfigurationPropertiesScan(basePackages = {"com.example.configure.pk6", "com.example.configure.pk8"})
@SpringBootApplication
// 在配置類加入註解@ImportResource
@ImportResource(locations = {"classpath:applicationContext.xml"})
public class Lesson7ConfigureApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Lesson7ConfigureApplication.class, args);
        Person bean = run.getBean(Person.class);
        System.out.println("bean = " + bean);

    }

}
