package com.iflytek.cn.medical_management.enums.handler;

import com.iflytek.cn.medical_management.enums.hashName.HasChineseName;
import com.iflytek.cn.medical_management.enums.EnumUtils;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * 通用枚举TypeHandler（适配所有实现HasChineseName接口的枚举）
 * 不再依赖硬编码的parseGender方法，基于接口+工具类实现通用解析
 */
@MappedJdbcTypes({JdbcType.VARCHAR, JdbcType.CHAR})
public class GenericEnumTypeHandler<E extends Enum<E> & HasChineseName> extends BaseTypeHandler<E> {

    private final Class<E> enumType; // 枚举实际类型
    private final Map<String, E> chineseNameMap; // 中文名称→枚举缓存

    /**
     * MyBatis自动调用的构造器（核心：传入枚举类型）
     * 替代复杂的泛型解析，直接通过构造器注入枚举类型
     */
    public GenericEnumTypeHandler(Class<E> enumType) {
        if (enumType == null) {
            throw new TypeException("枚举类型Class不能为空！");
        }
        this.enumType = enumType;
        // 复用EnumUtils创建缓存，无需反射调用parseXXX方法
        this.chineseNameMap = EnumUtils.createChineseNameMap(enumType.getEnumConstants());
    }

    /**
     * 无参构造器（兼容MyBatis低版本）
     * 若使用此构造器，需确保枚举类型已通过泛型明确指定
     */
    public GenericEnumTypeHandler() {
        // 解析泛型参数（保留兼容逻辑，优先用带参构造器）
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        if (!(genericSuperclass instanceof ParameterizedType parameterizedType)) {
            throw new TypeException("当前类必须指定泛型参数（如 GenericEnumTypeHandler<Gender>）");
        }
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        if (actualTypeArguments.length == 0 || !(actualTypeArguments[0] instanceof Class)) {
            throw new TypeException("无法解析泛型参数，请指定具体枚举类型");
        }
        this.enumType = (Class<E>) actualTypeArguments[0];
        this.chineseNameMap = EnumUtils.createChineseNameMap(enumType.getEnumConstants());
    }

    // 插入数据库：枚举 → 中文名称
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getChineseName()); // 调用接口方法，无硬编码
    }

    // 查询（列名）：数据库中文 → 枚举
    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return parseEnum(rs.getString(columnName));
    }

    // 查询（列索引）：数据库中文 → 枚举
    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return parseEnum(rs.getString(columnIndex));
    }

    // 存储过程：数据库中文 → 枚举
    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return parseEnum(cs.getString(columnIndex));
    }

    /**
     * 通用解析方法（复用EnumUtils，无硬编码方法名）
     */
    private E parseEnum(String dbValue) throws SQLException {
        if (dbValue == null || dbValue.trim().isEmpty()) {
            return null;
        }
        E result = EnumUtils.parseEnum(dbValue, enumType.getEnumConstants(), chineseNameMap);
        if (result == null) {
            throw new SQLException("数据库值 [" + dbValue + "] 无法解析为枚举 " + enumType.getName());
        }
        return result;
    }
}