package com.example.QLSV.service;

import com.example.QLSV.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public List<Student> findAll();
    public List<Student> findAllandSort(Sort sort);
    public Student findStudentById(Integer id) throws Exception;
    public List<Student> findStudentByName(String name) throws Exception;

    List<Student> findStudentByLop(String lop) throws Exception;

    public Student deleleStudentById(Integer id) throws Exception;
    public Student save(Student student);
    public Student updateStudentByID(Integer id,Student newStudent) throws Exception;
}
