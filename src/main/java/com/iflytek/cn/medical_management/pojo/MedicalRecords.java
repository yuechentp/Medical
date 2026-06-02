package com.iflytek.cn.medical_management.pojo;

import com.iflytek.cn.medical_management.enums.VisitType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class MedicalRecords {
    // 病例编号
    private Integer record_id;

    // 患者ID
    private Integer patient_id;

    // 主治医生ID
    private Integer doctor_id;

    // 就诊日期
    private LocalDate visit_date;

    // 就诊类型
    private VisitType visit_type;

    // 主诉
    private String chief_complaint;

    // 现病史
    private String present_illness;

    // 最终诊断
    private String final_diagnosis;

    // 治疗方案
    private String treatment_plan;

    // 处方信息
    private String prescription;

    // 检验结果
    private String lab_results;

    // 备注
    private String notes;

    // 关联的患者信息（可选，用于前端显示）
    private String patient_name;

    // 关联的医生信息（可选，用于前端显示）
    private String doctor_name;
}
