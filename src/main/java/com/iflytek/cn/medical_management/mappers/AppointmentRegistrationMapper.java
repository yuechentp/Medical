package com.iflytek.cn.medical_management.mappers;

import com.iflytek.cn.medical_management.pojo.Appointments;
import com.iflytek.cn.medical_management.pojo.Doctor;
import com.iflytek.cn.medical_management.pojo.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppointmentRegistrationMapper {
    // 新增患者
    void insertPatient(Patient patient);

    // 新增预约挂号
    void insertAppointment(Appointments appointments);

    // 根据医生名称或职称查询医生信息
    List<Doctor> queryDoctorByNameOrTitle(String query);

    // 根据医生ID查询挂号信息
    List<Appointments> queryAppointmentByDoctorId(Integer doctor_id);
}
