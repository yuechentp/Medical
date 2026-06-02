package com.iflytek.cn.medical_management.service;

import com.iflytek.cn.medical_management.pojo.Appointments;
import com.iflytek.cn.medical_management.pojo.Doctor;
import com.iflytek.cn.medical_management.pojo.Patient;

import java.util.List;

public interface AppointmentRegistrationService {
    // 患者注册
    void insertPatient(Patient patient);
    // 预约挂号
    void insertAppointment(Appointments appointments);
    // 根据医生名称或职称查询医生信息
    List<Doctor> queryDoctorByNameOrTitle(String query);
    // 根据医生ID查询挂号信息
    List<Appointments> queryAppointmentByDoctorId(Integer doctor_id);
}
