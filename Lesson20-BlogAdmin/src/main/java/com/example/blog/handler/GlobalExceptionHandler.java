package com.example.blog.handler;

import com.example.blog.handler.exp.IdTypeException;
import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // 處理 JSR303
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public String handlerBindException(MethodArgumentNotValidException e, Model model) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        model.addAttribute("errors", fieldErrors);
        return "/blog/error/bind";
    }

    @ExceptionHandler({IdTypeException.class})
    public String handleIdTypeException(IdTypeException idTypeException, Model model) {
        model.addAttribute("msg", idTypeException.getMessage());
        return "/blog/error/error";
    }

    @ExceptionHandler({Exception.class})
    public String handleDefalutException(Exception e, Model model) {
        model.addAttribute("msg", "請稍後重試!");
        return "/blog/error/error";
    }

}
