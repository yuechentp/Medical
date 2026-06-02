package com.iflytek.cn.medical_management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.Map;

public enum Title implements HasChineseName {
    // 主任医师，副主任医师，主治医师，住院医师，实习医师
    DIRECTOR("主任医师"),
    ASSISTANT("副主任医师"),
    ATTENDANT("主治医师"),
    INPATIENT("住院医师"),
    INTERN("实习医师");

    private final String chineseName;
    private static final Map<String, Title> CHINESE_NAME_MAP = EnumUtils.createChineseNameMap(values());

    Title(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    @JsonValue
    public String getChineseName() {
        return chineseName;
    }

    // 通用解析方法（替代原parseGender，保持兼容可保留）
    @JsonCreator
    public static Title fromString(String value) {
        return EnumUtils.parseEnum(value, values(), CHINESE_NAME_MAP);
    }

    // 兼容原有parseGender方法（可选，避免代码改动）
    public static Title parseGender(String value) {
        return fromString(value);
    }
}
