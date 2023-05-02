package com.example.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.apache.commons.lang3.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@SpringBootApplication
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(App.class);
        Environment env = app.run(args).getEnvironment();
        String port = env.getProperty("server.port");
        String contextPath = Optional.ofNullable(env.getProperty("server.servlet.context-path")).filter(StringUtils::isNotBlank).orElse("/");
        String baseUrl = port + contextPath;
        log.info("""
                    ----------------------------------------------------------\t
                    Application '{}' is running! Access URLs:\t
                    Local: \t\thttp://localhost:{}\t
                    External: \thttp://{}:{}
                ----------------------------------------------------------
                """,
                env.getProperty("spring.application.name") == null ? "App" : env.getProperty("spring.application.name"),
                baseUrl,
                InetAddress.getLocalHost().getHostAddress(),
                baseUrl);
    }

}
