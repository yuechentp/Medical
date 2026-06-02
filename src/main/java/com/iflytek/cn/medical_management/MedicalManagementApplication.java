package com.iflytek.cn.medical_management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.iflytek.cn.medical_management.mappers")
public class MedicalManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(MedicalManagementApplication.class, args);
    }
}
