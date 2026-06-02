package com.iflytek.cn.medical_management.service.impl;

import com.iflytek.cn.medical_management.mappers.ConditionQueryMapper;
import com.iflytek.cn.medical_management.pojo.MedicalRecords;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.iflytek.cn.medical_management.service.ConditionQueryService;
import org.springframework.stereotype.Service;

@Service
public class ConditionQueryServiceImpl implements ConditionQueryService {
    @Autowired
    private ConditionQueryMapper conditionQueryMapper;

    /**
     * 查询患者病历
     * @param patientId 患者ID
     * @return 患者病历列表
     */
    @Override
    public List<MedicalRecords> selectPatientRecords(Integer patientId) {
        return conditionQueryMapper.selectPatientRecords(patientId);
    }
}
