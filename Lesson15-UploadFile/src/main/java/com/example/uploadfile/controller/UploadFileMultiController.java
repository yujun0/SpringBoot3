package com.example.uploadfile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class UploadFileMultiController {

    @PostMapping("/uploadMultiFile")
    public String uploadFile(@RequestParam("upfile") MultipartFile[] multipartFiles) {
        Map<String, Object> info = new HashMap<>();

        try {
            for (MultipartFile multipartFile : multipartFiles) {
                if (!multipartFile.isEmpty()) {
                    info.put("上傳文件參數名", multipartFile.getName());   // upfile
                    info.put("內容類型", multipartFile.getContentType());

                    var ext = "unknown";
                    var filename = multipartFile.getOriginalFilename();    // 原始文件名稱，例如 a.png
                    if (filename.indexOf(".") > 0) {
                        ext = filename.substring(filename.indexOf(".") + 1);
                    }

                    var newFileName = UUID.randomUUID() + "." + ext;
                    var path = "D:/upload/" + newFileName;
                    info.put("上傳後文件名稱", newFileName);

                    multipartFile.transferTo(new File(path));
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("info = " + info);
        //防止刷新、重複上傳，重定向到index页面
        return "redirect:/index.html";
    }
}
