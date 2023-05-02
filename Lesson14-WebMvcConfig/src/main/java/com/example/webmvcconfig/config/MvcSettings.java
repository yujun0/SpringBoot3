package com.example.webmvcconfig.config;

import com.example.webmvcconfig.formatter.DeviceFormatter;
import com.example.webmvcconfig.interceptor.AuthInterceptor;
import com.example.webmvcconfig.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC配置：使用 JavaConfig的方式配置SpringMVC，代替原來的xml配置文件
 */
@Configuration
public class MvcSettings implements WebMvcConfigurer {

    // 頁面跳轉控制器，從請求直達view頁面(無需Controller)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置頁面控制：addViewController("請求uri"). 指定view(目標view)
        registry.addViewController("/welcome").setViewName("index");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    // 攔截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 權限攔截器
        AuthInterceptor authInterceptor = new AuthInterceptor();
        registry.addInterceptor(authInterceptor)
                .order(2)
                .addPathPatterns("/article/**")         // 攔截article開始的所有要求
                .excludePathPatterns("/article/query"); // 排除/article/query請求

        // 登入攔截器
        LoginInterceptor loginInterceptor = new LoginInterceptor();
        registry.addInterceptor(loginInterceptor)
                .order(1)                               // 順序，整數值，越小越先執行
                .addPathPatterns("/**")                 // 攔截所有請求
                .excludePathPatterns("/article/query"); // 排除/article/query請求
    }

}
