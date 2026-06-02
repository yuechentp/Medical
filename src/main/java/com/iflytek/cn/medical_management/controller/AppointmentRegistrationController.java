package com.iflytek.cn.medical_management.controller;

import com.iflytek.cn.medical_management.pojo.Appointments;
import com.iflytek.cn.medical_management.pojo.Doctor;
import com.iflytek.cn.medical_management.pojo.Patient;
import com.iflytek.cn.medical_management.service.AppointmentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointment-registration")
public class AppointmentRegistrationController {

    @Autowired
    private AppointmentRegistrationService appointmentRegistrationService;

    // 患者添加
    @RequestMapping("add-patient")
    public String add(@RequestBody Patient patient) {
        // 调用service层添加患者
        appointmentRegistrationService.insertPatient(patient);
        System.out.println(patient.getAllergy_history());
        return "add success";
    }

    // 预约挂号
    @RequestMapping("/registration")
    public String appointment(@RequestBody Appointments appointments) {
        // 调用service层添加预约挂号
        appointmentRegistrationService.insertAppointment(appointments);

        return "registration success";
    }

    // 通过医生名称或职称查询医生信息
    @RequestMapping("/doctor/{query}")
    public List<Doctor> getDoctor(@PathVariable String query) {
        // 调用service层查询医生信息
        List<Doctor> doctorList = appointmentRegistrationService.queryDoctorByNameOrTitle(query);
        // 返回医生信息
        return doctorList;
    }

    // 通过医生ID查询挂号信息
    @RequestMapping("/appointment/{doctor_id}")
    public List<Appointments> getAppointmentByDoctorId(@PathVariable Integer doctor_id) {
        // 调用service层查询挂号信息
        List<Appointments> appointments = appointmentRegistrationService.queryAppointmentByDoctorId(doctor_id);
        // 返回挂号信息
        return appointments;
    }
}
