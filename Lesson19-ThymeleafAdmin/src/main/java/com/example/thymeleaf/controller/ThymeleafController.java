package com.example.thymeleaf.controller;

import com.example.thymeleaf.vo.UserVO;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ThymeleafController {

    // 表達式，方法的返回值表示view，一個xxx.html夜面
    @GetMapping("/expression")
    public String expression(Model model) {
        // model中的數據，最後是放到request作用域的。
        // model.addAttribute("name", "財政部資訊中心"); ==> request.setAttribute("name", "財政部資訊中心");
        model.addAttribute("name", "財政部資訊中心");
        model.addAttribute("address", "台北市信義區");
        return "exp"; // 是一個view exp.html
    }

    // 鏈接表達式
    @GetMapping("/link")
    public String link(Integer id, String name, Model model) {
        model.addAttribute("id", id);
        model.addAttribute("myname", name);
        return "link";
    }

    // if - for
    @GetMapping("/if-for")
    public String ifFor(Model model) {
        model.addAttribute("login", true);
        UserVO user = new UserVO();
        user.setId(10);
        user.setName("Lisa");
        user.setAge(20);
        model.addAttribute("user", user);

        // 創建List集合
        List<UserVO> users = List.of(new UserVO(11, "Lisa", 21), new UserVO(12, "Susan", 22));
        model.addAttribute("users",users);

        return "base";
    }
}
