package com.example.problemdetail.exp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;


// 自定義異常類，讓SpringMVC的異常處理器使用
public class IsbnNotFoundException extends ErrorResponseException {

    public IsbnNotFoundException(HttpStatus status, String detail) {
        super(status, createProblemDetail(status, detail), null);
    }

    private static ProblemDetail createProblemDetail(HttpStatus status, String detail) {
        // 封裝 RFC7807 字段
        ProblemDetail problemDetail = ProblemDetail.forStatus(status);
        problemDetail.setType(URI.create("/api/probs/not-found"));
        problemDetail.setTitle("圖書異常");
        problemDetail.setDetail(detail);
        // 自定義字段
        problemDetail.setProperty("嚴重程度", "低");
        problemDetail.setProperty("客戶信箱", "test@gmail.com");
        return problemDetail;
    }

}
