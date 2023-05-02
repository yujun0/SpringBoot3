package com.example.blog;

import com.example.blog.settings.ArticleSettings;
import io.micrometer.common.util.StringUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Optional;

@EnableTransactionManagement
@MapperScan(basePackages = "com.example.blog.mapper")
@SpringBootApplication
@EnableConfigurationProperties({ArticleSettings.class})
public class Lesson20BlogAdminApplication {

	private static final Logger log = LoggerFactory.getLogger(Lesson20BlogAdminApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(Lesson20BlogAdminApplication.class);
		Environment env = app.run(args).getEnvironment();
		String port = Optional.ofNullable(env.getProperty("server.port")).filter(StringUtils::isNotBlank).orElse("8080") ;
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
