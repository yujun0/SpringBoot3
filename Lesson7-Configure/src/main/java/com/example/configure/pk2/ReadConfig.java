package com.example.configure.pk2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ReadConfig {

    @Autowired
    private Environment environment;

    public void print() {
        // 獲取某個 key 的值
        String name = environment.getProperty("app.name");

        // 判斷 key 是否存在
        if (environment.containsProperty("app.owner")) {
            System.out.println("app.owner是存在的");
        }

        // 讀取 key 的值，轉為期望的類型，同時提供默認值
        Integer port = environment.getProperty("app.port", Integer.class, 9001);
        String str = String.format("讀取的key值, name = %s, port = %d", name, port);
        System.out.println("str = " + str);
    }
}
