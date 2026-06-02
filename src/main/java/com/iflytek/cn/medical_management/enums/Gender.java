package com.iflytek.cn.medical_management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.Map;

public enum Gender implements HasChineseName {
    MALE("男"),
    FEMALE("女");

    private final String chineseName;
    private static final Map<String, Gender> CHINESE_NAME_MAP = EnumUtils.createChineseNameMap(values());

    Gender(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    @JsonValue
    public String getChineseName() {
        return chineseName;
    }

    // 通用解析方法（替代原parseGender，保持兼容可保留）
    @JsonCreator
    public static Gender fromString(String value) {
        return EnumUtils.parseEnum(value, values(), CHINESE_NAME_MAP);
    }

    // 兼容原有parseGender方法（可选，避免代码改动）
    public static Gender parseGender(String value) {
        return fromString(value);
    }
}