package com.iflytek.cn.medical_management.service.impl;

import com.iflytek.cn.medical_management.mappers.AppointmentRegistrationMapper;
import com.iflytek.cn.medical_management.pojo.Doctor;
import com.iflytek.cn.medical_management.pojo.Patient;
import com.iflytek.cn.medical_management.pojo.Appointments;
import com.iflytek.cn.medical_management.service.AppointmentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentRegistrationServiceImpl implements AppointmentRegistrationService {
    @Autowired
    private AppointmentRegistrationMapper appointmentRegistrationMapper;

    @Override
    public void insertPatient(Patient patient) {
        appointmentRegistrationMapper.insertPatient(patient);
    }

    @Override
    public void insertAppointment(Appointments appointments) {
        appointmentRegistrationMapper.insertAppointment(appointments);
    }

    @Override
    public List<Doctor> queryDoctorByNameOrTitle(String query) {
        return appointmentRegistrationMapper.queryDoctorByNameOrTitle(query);
    }
    @Override
    public List<Appointments> queryAppointmentByDoctorId(Integer doctor_id) {
        return appointmentRegistrationMapper.queryAppointmentByDoctorId(doctor_id);
    }
}
