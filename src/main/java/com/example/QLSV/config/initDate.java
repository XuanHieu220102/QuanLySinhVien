package com.example.QLSV.config;

import com.example.QLSV.entity.Student;
import com.example.QLSV.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class initDate {
    @Bean
    public CommandLineRunner initData(@Autowired StudentServiceImpl studentService){
        return args -> {
            studentService.save(new Student(1,"Dang Xuan Hieu","xuanhieu0031@gmail.com","KHMT02","CNTT"));
            studentService.save(new Student(2,"Dang Ngoc Hoang","ngochoang1102@gmail.com","KHMT01","CNTT"));
            studentService.save(new Student(4,"Dang Ngoc Chuyen","ngocchuyen192@gmail.com","CNTT03","CNTT"));
            studentService.save(new Student(5,"Dang Xuan Duong","xuanduong123@gmail.com","HTTT01","CNTT"));
            studentService.save(new Student(6,"Nguyen Ai Quoc","aiquoc1102@gmail.com","CNTT03","CNTT"));
        };
    }
}
