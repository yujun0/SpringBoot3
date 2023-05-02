package com.example.problemdetail.handler;

import com.example.problemdetail.exp.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

//@RestControllerAdvice
public class GlobalExceptionHandler {

//    // 用來返回自定義problemDetail物件
//    @ExceptionHandler(value = {BookNotFoundException.class})
//    public ProblemDetail handleBookNotFoundException(BookNotFoundException e) {
//        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
//        // type：異常類型，是一個uri，uri找到解決問題的途徑
//        problemDetail.setType(URI.create("/api/probs/not-found"));
//        problemDetail.setTitle("圖書異常");
//
//        // 增加自定義字段
//        // 時間戳
//        problemDetail.setProperty("timestamp", Instant.now());
//        // 客服信箱
//        problemDetail.setProperty("客服信箱", "test@gmail.com");
//        return problemDetail;
//    }

    @ExceptionHandler({BookNotFoundException.class})
    public ErrorResponse handleException(BookNotFoundException e) {
        return new ErrorResponseException(HttpStatus.NOT_FOUND, e);
    }

}
