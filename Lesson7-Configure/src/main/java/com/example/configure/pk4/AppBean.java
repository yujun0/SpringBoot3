package com.example.configure.pk4;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties：表示使用Bean對象讀取配置項 prefix: 表示配置文件中多個key的公共開始部分
 * 比如：app.name、app.port...，這裡的app就是prefix
 */
// @Component
// 創建普通bean，非spring代理
@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "app")
public class AppBean {

    // key的名稱與屬性名稱相同，調用屬性setXXX方法給屬性賦值
    // 非static屬性
    private String name;
    private String owner;
    private String port;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return "AppBean{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", port='" + port + '\'' +
                '}';
    }

}
