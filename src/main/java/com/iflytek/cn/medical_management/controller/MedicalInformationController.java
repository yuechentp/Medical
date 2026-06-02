package com.iflytek.cn.medical_management.controller;

import com.iflytek.cn.medical_management.pojo.MedicalRecords;
import com.iflytek.cn.medical_management.pojo.User;
import com.iflytek.cn.medical_management.service.MedicalInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medical-information")
public class MedicalInformationController {
    @Autowired
    private MedicalInformationService medicalInformationService;

    // 用户注册
    @RequestMapping("/register")
    public String register(@RequestBody User user) {
        medicalInformationService.registerUser(user);
        return "success";
    }

    // 用户登录
    @RequestMapping("/login")
    public User login(@RequestParam String account, @RequestParam String password) {
        User qu = medicalInformationService.queryUser(account, password);
        System.out.println(qu.getAccount() + "登录");

        return qu;
    }

    // 更新用户信息
    @RequestMapping("/update_user")
    public String updateUser(@RequestParam Integer user_id, @RequestParam Integer id) {
        medicalInformationService.updateUser(user_id, id);
        System.out.println("更新用户信息：id=" + id + ", user_id=" + user_id);
        return "success";
    }

     // 添加患者病历
    @RequestMapping("/add_records")
    public String insertPatientRecords(@RequestBody MedicalRecords records) {
        medicalInformationService.insertPatientRecords(records);
        return "success";
    }

    // 更新患者病历
    @RequestMapping("/update_records")
    public String updatePatientRecords(@RequestBody MedicalRecords records) {
        medicalInformationService.updatePatientRecords(records);
        return "success";
    }
}
