package com.iflytek.cn.medical_management.service.impl;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;
import com.iflytek.cn.medical_management.mappers.MedicalInformationMapper;
import com.iflytek.cn.medical_management.pojo.User;
import com.iflytek.cn.medical_management.service.MedicalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalInformationServiceImpl implements MedicalInformationService {
    @Autowired
    private MedicalInformationMapper medicalInformationMapper;

    // 用户注册
    @Override
    public void registerUser(User user) {
        // 检查用户账号是否已存在
        if (medicalInformationMapper.queryUser(user.getAccount(), user.getPassword()) != null) {
            throw new IllegalArgumentException("账号已存在");
        }
        // 注册用户
        medicalInformationMapper.registerUser(user);
    }

    // 查询用户
    @Override
    public User queryUser(String account, String password) {
        return medicalInformationMapper.queryUser(account, password);
    }

    // 更新用户信息
    @Override
    public void updateUser(Integer user_id, Integer id) {
        medicalInformationMapper.updateUser(user_id, id);
    }

    // 添加患者病历
    @Override
    public void insertPatientRecords(MedicalRecords records) {
        medicalInformationMapper.insertPatientRecords(records);
    }

    // 更新患者病历
    @Override
    public void updatePatientRecords(MedicalRecords records) {
        medicalInformationMapper.updatePatientRecords(records);
    }

}
