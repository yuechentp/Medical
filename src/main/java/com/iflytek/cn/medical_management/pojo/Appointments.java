package com.iflytek.cn.medical_management.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter @Getter
public class Appointments {
    // 预约ID
    Integer id;
    // 患者ID
    Integer patient_id;
    // 医生ID
    Integer doctor_id;
    // 预约日期
    LocalDate appointment_date;
    // 预约时间
    LocalTime appointment_time;
    // 预约日期时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    LocalDateTime appointment_datetime;
    // 患者姓名
    String patient_name;
}
