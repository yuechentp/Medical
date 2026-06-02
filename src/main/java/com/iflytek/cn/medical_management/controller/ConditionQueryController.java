package com.iflytek.cn.medical_management.controller;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;
import com.iflytek.cn.medical_management.service.ConditionQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/condition_query")
public class ConditionQueryController {
    @Autowired
    private ConditionQueryService conditionQueryService;

    // 查询患者病历
    @RequestMapping("/get_record/{patient_id}")
    public List<MedicalRecords> selectPatientRecords(@PathVariable Integer patient_id) {
        return conditionQueryService.selectPatientRecords(patient_id);
    }
}
