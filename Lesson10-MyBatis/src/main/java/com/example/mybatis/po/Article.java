package com.example.mybatis.po;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Article {
    /**
     * 主間
     */
    private Integer id;

    /**
     * 作者 ID
     */
    private Integer userId;

    /**
     * 文章標題
     */
    private String title;

    /**
     * 文章概要
     */
    private String summary;

    /**
     * 閱讀讀數
     */
    private Integer readCount;

    /**
     * 創建時間
     */
    private LocalDateTime createTime;

    /**
     * 最後修改時間
     */
    private LocalDateTime updateTime;

}

