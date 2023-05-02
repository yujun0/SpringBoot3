package com.example.mybatis.provider;

public class SqlProvider {

    // 定義static方法
    public static String selectArticle() {
        return "SELECT * FROM article WHERE id = #{id}";
    }

    public static String updateSql() {
        return "UPDATE article SET update_time = #{now} WHERE id = #{id}";
    }

    public static String insertSql() {
        return """
                INSERT INTO article(user_id, title, summary, read_count, create_time, update_time) 
                VALUES(#{userId}, #{title}, #{summary}, #{readCount}, #{createTime}, #{updateTime})
                """;
    }

    public static String deleteSql() {
        return """
                DELETE FROM article WHERE id = #{articleId}
                """;
    }
}
