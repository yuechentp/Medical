package com.iflytek.cn.medical_management.service;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;
import com.iflytek.cn.medical_management.pojo.User;

import java.util.List;

public interface MedicalInformationService {
    // 用户注册
    void registerUser(User user);

    // 查询用户
    User queryUser(String account, String password);

    // 更新用户信息
    void updateUser(Integer user_id, Integer id);

    // 插入患者病历
    void insertPatientRecords(MedicalRecords records);

    // 更新患者病历
    void updatePatientRecords(MedicalRecords records);
}
