package com.iflytek.cn.medical_management.mappers;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;

import java.util.List;

public interface ConditionQueryMapper {
    /**
     * 查询患者病历
     * @param patientId 患者ID
     * @return 患者病历列表
     */
    List<MedicalRecords> selectPatientRecords(Integer patientId);
}
