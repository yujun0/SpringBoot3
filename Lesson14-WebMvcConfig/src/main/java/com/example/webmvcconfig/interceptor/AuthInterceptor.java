package com.example.webmvcconfig.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {

    private final String COMMON_USER = "lisa";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("=====AuthInterceptor 權限攔截器=====");
        // 獲取登陸的用戶
        String loginUser = request.getParameter("loginUser");
        System.out.println("loginUser = " + loginUser);
        // 獲取操作的 url
        String requestURI = request.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        return COMMON_USER.equals(loginUser) &&
               (requestURI.startsWith("/article/add")
                || requestURI.startsWith("/article/edit")
                || requestURI.startsWith("/article/remove"));
    }
}
