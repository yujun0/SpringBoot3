package com.example.configure.pk7;

import com.example.configure.pk6.Security;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {

    // 創建bean對象，屬性值來自配置文件
    @ConfigurationProperties(prefix = "security")
    @Bean
    public Security createSecurity() {
        return new Security();
    }
}
