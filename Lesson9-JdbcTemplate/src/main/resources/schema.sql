CREATE TABLE `article`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT '主間',
    `user_id`     int(11) NOT NULL COMMENT '作者 ID',
    `title`       varchar(100) NOT NULL COMMENT '文章標題',
    `summary`     varchar(200) DEFAULT NULL COMMENT '文章概要',
    `read_count`  int(11) unsigned zerofill NOT NULL COMMENT '閱讀讀數',
    `create_time` datetime     NOT NULL COMMENT '創建時間',
    `update_time` datetime     NOT NULL COMMENT '最後修改時間',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;
