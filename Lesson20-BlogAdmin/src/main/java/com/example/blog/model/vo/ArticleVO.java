package com.example.blog.model.vo;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ArticleVO {
    private Integer id;
    private Integer userId;
    private String title;
    private String summary;
    private Integer readCount;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private String content;
}
