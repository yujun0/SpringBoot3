package com.example.web.controller;

import com.example.web.vo.ArticleVO;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ArticleController {
    /**
     * @Validated：驗證Bean BindingResult： 包含Bean的驗證結果
     */
    @PostMapping("article/add")
    public Map<String, String> addArticle(@Validated(ArticleVO.AddArticleGroup.class) @RequestBody ArticleVO vo, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            int errorIndex = 0;
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.put(errorIndex + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                errorIndex++;
            }
        }
        return errors;
    }

    @PostMapping("article/edit")
    public Map<String, String> editArticle(@Validated(ArticleVO.EditArticleGroup.class) @RequestBody ArticleVO vo, BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        if (result.hasErrors()) {
            int errorIndex = 0;
            for (FieldError fieldError : result.getFieldErrors()) {
                errors.put(errorIndex + "-" + fieldError.getField(), fieldError.getDefaultMessage());
                errorIndex++;
            }
        }
        return errors;
    }
}
