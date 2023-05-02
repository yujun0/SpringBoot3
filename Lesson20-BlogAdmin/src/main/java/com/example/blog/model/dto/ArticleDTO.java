package com.example.blog.model.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    //userId...
    private Integer id;
    private String title;
    private String summary;
    private String content;
}
