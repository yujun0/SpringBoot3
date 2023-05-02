package com.example.uploadfile.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UploadAction {

    @PostMapping("files")
    public String upload(HttpServletRequest request) {
        try {
            for (Part part: request.getParts()) {
                String filename = extractFileName(part);
                // 將文件寫入到服務器的目錄
                part.write(filename);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/index.html";
    }

    private String extractFileName(Part part) {
        // 上傳文件包含 header 頭 content-disposition，類似下面的內容, 可獲取文件原始名稱。
        // 如：form-data; name="dataFile"; filename="header.png"
        String contentDisp = part.getHeader("content-disposition");
        System.out.println("contentDisp = " + contentDisp);
        String[] items = contentDisp.split(";");
        for (String s: items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }
}
