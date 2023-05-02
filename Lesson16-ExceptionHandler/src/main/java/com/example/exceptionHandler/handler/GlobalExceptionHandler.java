package com.example.exceptionHandler.handler;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1. 在 class 的上面加入@ControllerAdvice，@RestControllerAdvice
 * 靈活組合@ControllerAdvice 和 @ResponseBody
 * 2. 在 class 中自定義方法，處裡各種異常
 * 方法定義同 Controller類中的方法定義
 */
// 控制器增強，給Controller增加異常處理功能，類似AOP的思想
//@ControllerAdvice
public class GlobalExceptionHandler {

    // 定義方法處理，數學異常
    /**
     * @ExceptionHandler：指定處理異常的方法
     * 位置：在方法的上面
     * 屬性：是異常類的class數組，如果系統拋出的異常類型與@ExceptionHandler聲明的相同，則由當前方法處理異常
     */
//    @ExceptionHandler({ArithmeticException.class})
//    public String handlerArithmeticException(ArithmeticException exception, Model model) {
//        String error = exception.getMessage();
//        model.addAttribute("error", error);
//        return "exp";   // 就是 view
//    }

    @ExceptionHandler({ArithmeticException.class})
    @ResponseBody
    public Map<String, String> handlerReturnDataException(ArithmeticException exception) {
        Map<String, String> error = new HashMap<>();
        error.put("msg", exception.getMessage());
        error.put("tips", "被除數不能為0");

        return error;
    }

    // 處理 JSR303 驗證參數的異常
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public Map<String, Object> handlerJSR303Exception (MethodArgumentNotValidException e) {
        System.out.println("========JSR 303========");
        Map<String, Object> map = new HashMap<>();
        BindingResult result = e.getBindingResult();
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            for (int i = 0; i < errors.size(); i++) {
                FieldError fieldError = errors.get(i);
                map.put(i + "-" + fieldError.getField(), fieldError.getDefaultMessage());
            }
        }
        return map;
    }

}
