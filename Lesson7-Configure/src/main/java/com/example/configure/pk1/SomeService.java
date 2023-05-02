package com.example.configure.pk1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.StringJoiner;

@Service
public class SomeService {

    // 使用@Value("${key:默認值}")

    @Value("${app.name}")
    private String name;

    @Value("${app.owner}")
    private String owener;

    // app.port:8008 -> 如果配置文件有app.port還是會讀取文件裡的值，若文件找不到這個值，則會使用8008預設值
    @Value("${app.port:8008}")
    private Integer port;

    public void printValue() {
        StringJoiner joiner = new StringJoiner(";");
        joiner.add(name).add(owener).add(String.valueOf(port));

        String result = joiner.toString();
        System.out.println("result = " + result);
    }
}
