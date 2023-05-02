package com.example.servletfilter.config;

import com.example.servletfilter.filter.AuthFilter;
import com.example.servletfilter.filter.LogFilter;
import com.example.servletfilter.servlet.LoginServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

@Configuration
public class WebAppConfig {
    @Bean
    public ServletRegistrationBean<LoginServlet> addServlet() {
        ServletRegistrationBean<LoginServlet> registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new LoginServlet());
        registrationBean.addUrlMappings("/user/login");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

//    @Bean
//    public FilterRegistrationBean addFilter() {
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new LogFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        return filterRegistrationBean;
//    }

    // 註冊 Filter，指定順序
    @Bean
    public FilterRegistrationBean addLogFilter() {
        FilterRegistrationBean log = new FilterRegistrationBean();
        log.setFilter(new LogFilter());
        log.addUrlPatterns("/*");
        log.setOrder(2); // 設置順序
        return log;
    }

    @Bean
    public FilterRegistrationBean addAuthFilter() {
        FilterRegistrationBean auth = new FilterRegistrationBean();
        auth.setFilter(new AuthFilter());
        auth.addUrlPatterns("/*");
        auth.setOrder(3); // 越小越先執行
        return auth;
    }

    @Bean
    public FilterRegistrationBean addOtherFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        // 創建 Filter 對象
        CommonsRequestLoggingFilter commonLog = new CommonsRequestLoggingFilter();
        // 包含請求uri
        commonLog.setIncludeQueryString(true);
        // 登記 Filter
        filterRegistrationBean.setFilter(commonLog);
        // 攔截所有地址
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }

}
