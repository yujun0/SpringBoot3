package com.example.blog.model.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ArticleParam {
    // 分組
    public static interface AddArticle {}

    public static interface EditArticle {}

    @NotNull(message = "修改時必須有id", groups = {EditArticle.class})
    @Min(value = 1, message = "文章id大於{value}", groups = {EditArticle.class})
    private Integer id; //文章id

    @NotBlank(message = "請輸入文章標題", groups = {AddArticle.class, EditArticle.class})
    @Size(min = 2, max = 20, message = "文章標題在{min}-{max}", groups = {AddArticle.class, EditArticle.class})
    private String title;

    @NotBlank(message = "請輸入文章副標題", groups = {AddArticle.class, EditArticle.class})
    @Size(min = 10, max = 30, message = "文章副標題在{min}-{max}", groups = {AddArticle.class, EditArticle.class})
    private String summary;

    @NotBlank(message = "請輸入文章内容", groups = {AddArticle.class, EditArticle.class})
    @Size(min = 20, max = 8000, message = "文章内容至少{min}字，最多{max}字", groups = {AddArticle.class, EditArticle.class})
    private String content;
}
