package com.example.webmvcconfig.controller;

import com.example.webmvcconfig.formatter.DeviceFormatter;
import com.example.webmvcconfig.model.DeviceInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class DeviceController {

    @PostMapping("/device/add")
    public String addDevice(@RequestParam("info") DeviceInfo info) {
//        DeviceFormatter formatter = new DeviceFormatter();
//        String formattedString = formatter.print(info, Locale.getDefault());
//        return "接收到的設備數據: " + formattedString;
        return "接收到的設備數據： " + info.toString();
    }

}
