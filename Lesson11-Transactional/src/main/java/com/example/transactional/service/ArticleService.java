package com.example.transactional.service;

import com.example.transactional.po.ArticlePO;

public interface ArticleService {

    // 發布新的文章
    boolean postNewArticle(ArticlePO article, String content);

    // 無效事務方法
    boolean managerArticle(ArticlePO article, String content);
    // 無效事務方法
    boolean postNewArticleThread(ArticlePO article, String content);
}
