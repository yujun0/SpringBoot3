package com.example.transactional.service.impl;

import com.example.transactional.mapper.ArticleMapper;
import com.example.transactional.po.ArticleDetailPO;
import com.example.transactional.po.ArticlePO;
import com.example.transactional.service.ArticleService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class ArticleServiceImpl implements ArticleService {

    // 注入 mapper
    @Resource
    private ArticleMapper articleMapper;

    /**
     * @Transactional：事務控制註解 位置：
     * 1. 方法上面
     * 2. class上面
     * 更推薦在方法上面使用，因為若在class上面，並不是所有的方法都需要事務控制
     * <p>
     * 事務回滾：
     * 1. 默認對運行異常時，執行回滾rollback
     * 2. rollbackFor：需要回滾的異常類列表
     */
    @Transactional(rollbackFor = {IOException.class})
    @Override
    public boolean postNewArticle(ArticlePO article, String content) {
        // 添加新的文章
        int rows = articleMapper.insertArticle(article);

        // 拋出異常
        if (article.getReadCount() < 1) {
            throw new RuntimeException("文章閱讀數量最小是1");
        }
        // 添加文章內容
        ArticleDetailPO detail = new ArticleDetailPO();
        detail.setArticleId(article.getId());
        detail.setContent(content);

        int detailRows = articleMapper.insertArticleDetail(detail);

        return (rows + detailRows) == 2;
    }

    @Override
    public boolean managerArticle(ArticlePO article, String content) {
        return postNewArticle(article, content);
    }

    @Transactional
    @Override
    public boolean postNewArticleThread(ArticlePO article, String content) {
        System.out.println("Start 父線程：" + Thread.currentThread().threadId());
        Thread thread = new Thread(() -> {
            System.out.println("子線程：" + Thread.currentThread().threadId());
            // 新增文章
            articleMapper.insertArticle(article);

            // 拋出異常
            if (article.getReadCount() < 1) {
                throw new RuntimeException("文章閱讀數量最小是1");
            }

            // 添加文章內容
            ArticleDetailPO detail = new ArticleDetailPO();
            detail.setArticleId(article.getId());
            detail.setContent(content);
            articleMapper.insertArticleDetail(detail);
        });

        // 線程啟動
        thread.start();
        try {
            // 等thread執行完成，再繼續後面的代碼
            thread.join();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("End 父線程：" + Thread.currentThread().threadId());
        return true;
    }

}
