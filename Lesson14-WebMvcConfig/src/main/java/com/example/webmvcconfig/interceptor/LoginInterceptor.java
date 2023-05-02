package com.example.webmvcconfig.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

public class LoginInterceptor implements HandlerInterceptor {

    private final List<String> permitUser;

    public LoginInterceptor() {
        permitUser = List.of("lisa", "susan", "admin", "root");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====LoginInterceptor 登入攔截器=====");
        // 獲取登陸的用戶
        String loginUser = request.getParameter("loginUser");

        return StringUtils.hasText(loginUser) && permitUser.contains(loginUser);
    }
}
