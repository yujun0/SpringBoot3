package com.example.web.controller;

import com.example.web.model.User;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class JSONViewController {
    // 顯示json view，包含json數據
    @RequestMapping("/exam/json")
    public void responseJson(HttpServletResponse response) throws IOException {
        String json = "{\"name\":\"lisa\",\"age\":26}";
        // 應答，透過HttpServletResponse輸出
        response.setContentType("application/json;charset=utf-8");

        try (PrintWriter out = response.getWriter()) {
            out.println(json);
        }
    }

    /**
     * 接收請求的註解
     *
     * @GetMapping：接收get請求，簡化的@RequestMapping(method=RequestMethod.GET)
     * @PostMapping：接收post請求
     * @PutMapping：接收put請求
     * @DeleteMapping：接收delete請求
     */
    // @RequestMapping("/exam/user")
    @GetMapping("/exam/user")
    // SpringMVC 支持controller方法返回object，由框架將object使用jackson轉為json，並輸出
    // User --> 使用Jackson工具庫的ObjectMapper對象將user轉為 JSON 格式字符串 --> HttpServletResponse輸出
    @ResponseBody
    public User getUserJson() {
        User user = new User();
        user.setName("Susan");
        user.setAge(22);
        return user;
    }

}
