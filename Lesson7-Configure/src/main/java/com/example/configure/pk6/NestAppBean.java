package com.example.configure.pk6;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

//@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "myapp")
public class NestAppBean {
    private String name;
    private String owner;
    private String port;
    private Security security;

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

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    @Override
    public String toString() {
        return "NestAppBean{" +
                "name='" + name + '\'' +
                ", owner='" + owner + '\'' +
                ", port='" + port + '\'' +
                ", security=" + security +
                '}';
    }
}
