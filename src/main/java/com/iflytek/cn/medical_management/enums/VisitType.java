package com.iflytek.cn.medical_management.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.Map;

public enum VisitType implements HasChineseName {
    // 访问类型枚举：初诊、复诊、急诊、住院
    INITIAL("初诊"),
    FOLLOW_UP("复诊"),
    EMERGENCY("急诊"),
    INPATIENT("住院");



    private final String chineseName;
    private static final Map<String, VisitType> CHINESE_NAME_MAP = EnumUtils.createChineseNameMap(values());

    VisitType(String chineseName) {
        this.chineseName = chineseName;
    }

    @Override
    @JsonValue
    public String getChineseName() {
        return chineseName;
    }

    // 通用解析方法（无需parseGender，复用EnumUtils）
    @JsonCreator
    public static VisitType fromString(String value) {
        return EnumUtils.parseEnum(value, values(), CHINESE_NAME_MAP);
    }

    // 业务别名方法（可选，兼容原有代码）
    public static VisitType parseVisitType(String value) {
        return fromString(value);
    }
}