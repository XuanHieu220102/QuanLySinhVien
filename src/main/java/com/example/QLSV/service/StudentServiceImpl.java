package com.example.QLSV.service;

import com.example.QLSV.entity.Student;
import com.example.QLSV.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    @Override
    public List<Student> findAllandSort(Sort sort) {
        return studentRepository.findAll(sort);
    }


    @Override
    public Student findStudentById(Integer id) throws Exception {
        return studentRepository.findById(id).orElseThrow(()->new Exception("Id nay khong ton tai"));
    }

    @Override
    public List<Student> findStudentByName(String name) throws Exception {
        return studentRepository.findByName(name);
    }

    @Override
    public List<Student> findStudentByLop(String lop) throws Exception {
        return studentRepository.findByLop(lop);
    }


    @Override
    public Student deleleStudentById(Integer id) throws Exception {
        Student student = studentRepository.findById(id).orElseThrow(()->new Exception("Khong tim thay id nay"));
        studentRepository.delete(student);
        return student;
    }



    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student updateStudentByID(Integer id, Student newStudent){
        Student student = studentRepository.findById(id).get();
        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setLop(newStudent.getLop());
        student.setKhoa(newStudent.getKhoa());
        studentRepository.save(student);
        return student;
    }
}
