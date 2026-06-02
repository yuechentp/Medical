package com.iflytek.cn.medical_management.enums;

import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;

import java.util.HashMap;
import java.util.Map;

public class EnumUtils {

    /**
     * 通用方法：创建“中文名称→枚举”的缓存Map（避免重复遍历枚举值）
     * @param enumValues 枚举值数组（如 Gender.values()）
     * @param <E> 枚举类型（需同时实现 Enum + HasChineseName）
     */
    public static <E extends Enum<E> & HasChineseName> Map<String, E> createChineseNameMap(E[] enumValues) {
        Map<String, E> map = new HashMap<>();
        for (E e : enumValues) {
            map.put(e.getChineseName(), e);
        }
        return map;
    }

    /**
     * 通用方法：解析枚举（支持中文名称/英文枚举名，忽略大小写）
     * @param value 待解析的值（中文/英文枚举名）
     * @param enumValues 枚举值数组
     * @param chineseNameMap 中文名称缓存Map
     * @param <E> 枚举类型（需同时实现 Enum + HasChineseName）
     * @return 解析后的枚举（解析失败返回null，避免抛异常）
     */
    public static <E extends Enum<E> & HasChineseName> E parseEnum(String value, E[] enumValues, Map<String, E> chineseNameMap) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }

        String key = value.trim();

        // 1. 优先查中文名称缓存
        E enumInstance = chineseNameMap.get(key);
        if (enumInstance != null) {
            return enumInstance;
        }

        // 2. 忽略大小写查中文名称
        for (Map.Entry<String, E> entry : chineseNameMap.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(key)) {
                return entry.getValue();
            }
        }

        // 3. 尝试解析英文枚举名（忽略大小写）
        try {
            Class<E> enumClass = (Class<E>) enumValues[0].getDeclaringClass();
            return Enum.valueOf(enumClass, key.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // 解析失败返回null，交给调用方处理
        }
    }
}