package com.iflytek.cn.medical_management.pojo;

import com.iflytek.cn.medical_management.enums.Gender;
import com.iflytek.cn.medical_management.enums.Status;
import com.iflytek.cn.medical_management.enums.Title;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class Doctor {
    // 医生ID
    private Integer doctor_id;
    // 姓名
    private String name;
    // 性别
    private Gender gender;
    // 出生日期
    private LocalDate birth_date;
    // 身份证号
    private String id_card;
    // 联系电话
    private String phone;
    // 职称
    private Title title;
    // 专业特长
    private String specialty;
    // 工作年限
    private int work_year;
    // 状态
    private Status status;
}
