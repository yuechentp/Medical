package com.iflytek.cn.medical_management.service;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;

import java.util.List;

public interface ConditionQueryService {
    // 查询患者病历
    List<MedicalRecords> selectPatientRecords(Integer patientId);
}
