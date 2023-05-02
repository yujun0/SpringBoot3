package com.example.blog.service;

import com.example.blog.model.dto.ArticleDTO;
import com.example.blog.model.po.ArticlePO;

import java.util.List;

public interface ArticleService {
    // 獲取首頁文章列表
    List<ArticlePO> queryTopArticle();

    // 發布文章（article ，article_detail）
    boolean addArticle(ArticleDTO dto);

    // 根據主鍵查詢文章
    ArticleDTO queryByArticleId(Integer id);

    // 修改文章屬性和內容
    boolean modifyArticle(ArticleDTO articleDTO);

    // 刪除文章
    boolean removeArticle(List<Integer> idList);

    // 查詢文章內容前20個字符
    String queryTop20Content(Integer id);
}
