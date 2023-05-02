package com.example.problemdetail.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProblemController {

    @GetMapping("/probs/not-found")
    public String doNotFound(){
        return "圖書的isbn可能不存在...";
    }
}
