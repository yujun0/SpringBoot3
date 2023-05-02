package com.example.blog.settings;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "article")
public class ArticleSettings {
    private Integer lowRead;
    private Integer topRead;
}
