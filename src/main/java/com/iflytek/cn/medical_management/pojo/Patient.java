package com.iflytek.cn.medical_management.pojo;

import com.iflytek.cn.medical_management.enums.Gender;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class Patient {  // 患者类
    private Integer patient_id;  // 患者ID
    private String name;        // 姓名
    private Gender gender;      // 性别
    private Integer age;        // 年龄
    private String id_card;     // 身份证号
    private String phone;       // 手机号
    private String province;    // 省份
    private String city;        // 城市
    private String district;    // 区县
    private String detailed_address;    // 详细地址
    private String medical_history;     // 既往病史
    private String allergy_history;     // 过敏史
}
