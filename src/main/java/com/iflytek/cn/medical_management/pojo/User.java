package com.iflytek.cn.medical_management.pojo;

import com.iflytek.cn.medical_management.enums.UserType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
    // 用户ID
    private Integer user_id;

    // 用户账号
    private String account;

    // 密码
    private String password;

    // 用户类型
    private UserType type;
}
