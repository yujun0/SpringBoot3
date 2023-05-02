package com.example.web.controller;

import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.OutputStream;
import java.io.Reader;

@RestController
public class ExamplePathController {
    /**
     * ？ 匹配只有一個字符
     * o -> GET http://localhost:8080/file/test.html
     * x -> GET http://localhost:8080/file/teest.html
     */
    @GetMapping("/file/t?st.html")
    public String path1(HttpServletRequest request) {
        return "path 請求 = " + request.getRequestURI();
    }

    /**
     * *：匹配一個路徑段中的 0 或多個字符
     * o -> GET http://localhost:8080/images/user.gif
     * o -> GET http://localhost:8080/images/cat.gif
     * o -> GET http://localhost:8080/images/.gif
     * x -> GET http://localhost:8080/images/gif/header.gif
     * x -> GET http://localhost:8080/images/dog.jpg
     */
    @GetMapping("images/*.gif")
    public String path2(HttpServletRequest request) {
        return "* 請求 = " + request.getRequestURI();
    }

    /**
     * ** 匹配 0 或多段路徑， 匹配/pic 開始的所有請求
     * o -> GET http://localhost:8080/pic/p1.gif
     * o -> GET http://localhost:8080/pic/20222/p1.gif
     * o -> GET http://localhost:8080/pic/user
     * o -> GET http://localhost:8080/pic/
     */
    @GetMapping("pic/**")
    public String path3(HttpServletRequest request) {
        return "/pic/** 請求 = " + request.getRequestURI();
    }

    /**
     * {*id} 匹配 /order 開始的所有請求， id 表示 order 後面直到路徑末尾的所有内容。
     * id 自定義路徑變量名稱。與 @PathVariable 一樣使用
     * o -> GET http://localhost:8080/order/1001
     * o -> GET http://localhost:8080/order/1001/2023-02-16
     * 注意：@GetMapping("/order/{*id}/{*date}") 是無效的， {*..}後面不能再有匹配規則了
     */
    @GetMapping("order/{*id}")
    public String path4(@PathVariable("id") String orderId, HttpServletRequest request) {
        return "order/{*id} 請求 = " + request.getRequestURI() + ", id = " + orderId;
    }

    /**
     * fname是自定義路徑變量名稱
     * : 後面是正則匹配
     * :\\w+ 正則匹配， xxx.log
     * w 表示字符
     * + 代表最少一個
     * o -> GET http://localhost:8080/pages/req.log
     * o -> GET http://localhost:8080/pages/111.log
     * x -> GET http://localhost:8080/pages/req.txt
     * x -> GET http://localhost:8080/pages/###.log
     *
     */
    @GetMapping("/pages/{fname:\\w+}.log")
    public String path5(@PathVariable("fname") String filename, HttpServletRequest request) {
        return "/pages/{fname:\\w+}.log 請求 = " + request.getRequestURI() + ", filename = " + filename;
    }

    @GetMapping("/pages/get")
    public String path6(HttpServletRequest request) {
        return "path6 請求： " + request.getRequestURI();

    }

}
