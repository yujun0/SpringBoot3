package com.example.web.controller;

import com.example.web.model.Person;
import com.example.web.model.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

@RestController
public class ParameterController {

    // 一一對應，適合接收簡單類型數據，如：String、int、long、double、float，參數量比較少
    // htpp://localhost:8080/p1?name=lisa&age=20&sex=w
    @GetMapping("/param/p1")
    public String p1(String name, Integer age, String sex) {
        return "接收參數: " + name + "," + age + "," + sex;
    }

    // 使用物件接收參數，要求物件的屬性名稱和請求中的參數名一樣，屬性有set方法，class有無參數構造方法
    @GetMapping("/param/p2")
    public String p2(Person person, String type) {
        return "接收參數, 使用物件: " + person.toString();
    }

    // 使用 HttpServletRequest 接收參數
    @GetMapping("/param/p3")
    public String p3(HttpServletRequest request) {
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");

        return "name = " + name + ", age = " + age + ", sex = " + sex;
    }

    // 使用 RequestParam
    // 不加 也能接收，加了 強制由框架解析參數
    @GetMapping("/param/p4")
    public String p4(@RequestParam(value = "name", required = true) String name,
                     @RequestParam(value = "age", required = false, defaultValue = "24") Integer age) {
        return "p4, name = " + name + ", age = " + age;
    }

    // 使用 RequestBody 接收 json，post請求體數據

    /**
     * 前端數據： { "username":"lisa", "age":20 }
     *
     * @RequestBody： 從請求體中讀取 json 數據，將數據轉為形參對象的屬性值
     * 框架創建 User物件，將 username、age key的值賦值給兩個同名的屬性
     * 前端請求中需要指定：頭 Content-Type：application/json
     */
    @PostMapping("/param/json")
    public String p6(@RequestBody User user) {
        System.out.println("接收的 json：" + user.toString());
        return "p6, json 轉為 User物件：" + user;
    }


    // 使用 Reader-InputStream 讀取 post 請求體數據
    @PostMapping("/param/json2")
    public String p7(Reader reader) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader bin = new BufferedReader(reader)) {
            String line;
            while ((line = bin.readLine()) != null) {
                content.append(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return "p7, reader = " + content;
    }

    // 接收數組 多個值
    @GetMapping("/param/vals")
    public String getMultiVal(Integer[] id) {
        List<Integer> idList = Arrays.stream(id).toList();
        return idList.toString();
    }

}
