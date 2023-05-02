package com.example.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@Component
@Aspect
public class LogAspect {

    // service這個package和子package中{service.} 的 任意類{.*} 的 任意方法{.*} 任意的參數(..)
    @Before("execution(* com.example.aop.service..*.*(..))")
    // 功能增強的方法
    public void sysLog(JoinPoint joinPoint) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        log.add(formatter.format(LocalDateTime.now()));

        // 當前執行的業務方法名稱
        String methodName = joinPoint.getSignature().getName();

        // 目標方法參數列表
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }
        System.out.println("方法執行日誌： " + log);
    }

}
