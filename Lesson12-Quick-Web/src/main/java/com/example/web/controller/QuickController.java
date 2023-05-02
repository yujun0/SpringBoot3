package com.example.web.controller;

import com.example.web.model.Role;
import com.example.web.model.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * @Controller：創建控制器object，控制器能夠接收request，並response給browser 控制器也叫做處理器
 */
@Controller
public class QuickController {
    // 定義方法處理請求，方法叫做控制器方法(處理器方法)
    // Model表示模型，儲存數據。這個數據最後是放在request作用域
    // HttpServletRequest放在的作用域中
    @RequestMapping("/exam/quick")
    public String quick(Model model) {
        // 調用service，處理請求，獲取數據
        // 業務處理結果數據，放入到Model模型
        model.addAttribute("title", "web開發");
        model.addAttribute("time", LocalDateTime.now());

        // 指定視圖，顯示數據
        return "quick"; // -> 視圖文件的名稱
    }

    @GetMapping("/hello")
    public ModelAndView hello(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Lisa");
        modelAndView.addObject("age", 20);
        modelAndView.setViewName("hello");

        return modelAndView;
    }

    @GetMapping("/show/json")
    @ResponseBody
    public User getUserRole() {
        User user = new User();
        user.setName("Lisa");
        user.setAge(26);

        Role role = new Role();
        role.setId(5892);
        role.setRoleName("管理員");
        role.setMemo("具有較高的權限");
        user.setRole(role);

        return user;
    }

    @GetMapping("/show/json3")
    @ResponseBody
    public ResponseEntity<User> returnEntity() {
        User user = new User();
        user.setName("Lisa");
        user.setAge(26);

        Role role = new Role();
        role.setId(5892);
        role.setRoleName("管理員");
        role.setMemo("具有較高的權限");
        user.setRole(role);

        return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
    }

    @GetMapping("/map/json")
    @ResponseBody
    public Map getMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1001);
        map.put("address", "信義區");
        map.put("city", "台北");
        return map;
    }

    // 接收時間
    @GetMapping("/param/date")
    @ResponseBody
    public String paramDate(LocalDateTime date) {
        return "時間： " + date;
    }


    // @DateTimeFormat 格式化日期，可以方法，参数，字段上使用。
    @GetMapping("/test/date")
    @ResponseBody
    public String paramDate2(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return "日期：" + date;
    }
    // 無須設置：spring.mvc.format.date-time=yyyy-MM-dd HH:mm:ss
}
