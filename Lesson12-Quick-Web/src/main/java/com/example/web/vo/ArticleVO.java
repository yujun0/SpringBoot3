package com.example.web.vo;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class ArticleVO {
    // group 就是 介面名
    public interface AddArticleGroup {}
    public interface EditArticleGroup {}

    // 文章主鍵
    @NotNull(message = "文章 id 不能為空", groups = {EditArticleGroup.class})
    @Min(value = 1, message = "文章 id 從 1 開始", groups = {EditArticleGroup.class})
    private Integer id;

    @NotNull(message = "必須有作者", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private Integer userId;

    // 同一個屬性可以指定多個annotation
    @NotBlank(message = "文章必須有標題", groups = {AddArticleGroup.class, EditArticleGroup.class})
    // @Size 中 null 認為是有效值，所以需要 @NotBlank
    @Size(min = 3, max = 30, message = "標題必須3個字以上", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private String title;

    @NotBlank(message = "文章必須有副標題", groups = {AddArticleGroup.class, EditArticleGroup.class})
    @Size(min = 5, max = 60, message = "副標題必須5個字以上", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private String summary;

    @DecimalMin(value = "0", message = "閱讀數量不能小於0", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private Integer readCount;

    @Email(message = "信箱格式不正確", groups = {AddArticleGroup.class, EditArticleGroup.class})
    private String email;
}
