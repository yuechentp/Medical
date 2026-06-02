package com.iflytek.cn.medical_management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.Map;

public enum Status implements HasChineseName {
    // 在职，休假，离职，停职

    ACTIVE("在职"),
    VACATION("休假"),
    RESIGN("离职"),
    SUSPENSION("停职");

    private final String chineseName;
    private static final Map<String, Status> CHINESE_NAME_MAP = EnumUtils.createChineseNameMap(values());

    Status(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    @JsonValue
    public String getChineseName() {
        return chineseName;
    }

    // 通用解析方法（替代原parseGender，保持兼容可保留）
    @JsonCreator
    public static Status fromString(String value) {
        return EnumUtils.parseEnum(value, values(), CHINESE_NAME_MAP);
    }

    // 兼容原有parseGender方法（可选，避免代码改动）
    public static Status parseGender(String value) {
        return fromString(value);
    }
}
