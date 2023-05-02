package com.example.web.model;

import lombok.Data;

@Data
public class Role {
    //角色 ID
    private Integer id;
    //角色名稱
    private String roleName;
    //角色說明
    private String memo;
}
