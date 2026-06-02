package com.iflytek.cn.medical_management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.Map;

public enum UserType implements HasChineseName {
    PATIENT("患者"),
    DOCTOR("医生"),
    ADMIN("管理员");

    private final String chineseName;
    private static final Map<String, UserType> CHINESE_NAME_MAP = EnumUtils.createChineseNameMap(values());

    UserType(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    @JsonValue
    public String getChineseName() {
        return chineseName;
    }

    // 通用解析方法（替代原parseGender，保持兼容可保留）
    @JsonCreator
    public static UserType fromString(String value) {
        return EnumUtils.parseEnum(value, values(), CHINESE_NAME_MAP);
    }

    // 兼容原有parseGender方法（可选，避免代码改动）
    public static UserType parseUserType(String value) {
        return fromString(value);
    }
}
