package com.example.aop.service.impl;

import com.example.aop.service.SomeService;
import org.springframework.stereotype.Service;

@Service
public class SomeServiceImpl implements SomeService {
    @Override
    public void query(Integer id) {
        System.out.println("SomeService業務方法query執行了");
    }

    @Override
    public void save(String name, int age) {
        System.out.println("SomeService業務方法save執行了");
    }
}
