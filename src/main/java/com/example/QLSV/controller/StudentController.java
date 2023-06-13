package com.example.QLSV.controller;

import com.example.QLSV.entity.Student;
import com.example.QLSV.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private HttpServletRequest request;
    @GetMapping(path = {"","/"})
    public String findAll( ModelMap modelMap){
        String sortBy = request.getParameter("sort_by");
        String sortDirection = request.getParameter("sort_direction");
//
//        Sort sort;
//        if(sortDirection == null ||sortDirection.equals("asc")){
//            sort = Sort.by(Sort.Direction.ASC,sortBy);
//        }else {
//            sort = Sort.by(Sort.Direction.DESC,sortBy);
//        }

        String sortField = sortBy == null ? "id" : sortBy;
        Sort sort = (sortDirection == null || sortDirection.equals("asc"))?
                Sort.by(Sort.Direction.ASC,sortField):
                Sort.by(Sort.Direction.DESC,sortField);
//        int page = 3;
//        int limit = 15;
//        Pageable pageable = PageRequest.of(page,limit,sort);
//        Page students = (Page) studentService.findAll(pageable);
        List<Student> students = studentService.findAllandSort(sort);
        modelMap.addAttribute("students",students);
        return "home";
    }

    @GetMapping(path = "/{id}")
    public String findStudentById(@PathVariable(name = "id") Integer id, ModelMap modelMap){
        try {
            modelMap.addAttribute("student",studentService.findStudentById(id));
            return "get";
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return "error";
        }
    }

    @PostMapping(path = "/searchName")
    public String findStudentByName(ModelMap modelMap,@RequestParam("username") String username){
        try {
            if(username == null || username.equals("")){
                modelMap.addAttribute("students",studentService.findAll());
                return "home";
            }
            modelMap.addAttribute("students",studentService.findStudentByName(username));
            return "home";
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return "error";
        }
    }
    @PostMapping(path = "/searchClass")
    public String findStudentByClass(@RequestParam("class") String lop, ModelMap modelMap){
        try {
            if(lop == null || lop.equals("")){
                modelMap.addAttribute("students",studentService.findAll());
                return "home";
            }
            modelMap.addAttribute("students",studentService.findStudentByLop(lop));
            return "home";
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return "error";
        }
    }

    @GetMapping(path = "/add")
    public String addStudent(ModelMap modelMap){
        modelMap.addAttribute("student",new Student());
        return "add";
    }

    @PostMapping(path = "/add")
    public String addStudent(@ModelAttribute(name = "student") Student student){
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleleStudentByID(@PathVariable(name = "id") Integer id, ModelMap modelMap){
        try {
            studentService.deleleStudentById(id);
            return "redirect:/";
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return "error";
        }
    }

    @GetMapping(path = "/update/{id}")
    public String updateStudentById(@PathVariable(name = "id") Integer id, ModelMap modelMap){
        try {
            Student student = studentService.findStudentById(id);
            modelMap.addAttribute("student",student);
            return "update";
        }catch (Exception e){
            modelMap.addAttribute("message",e.getMessage());
            return "error";
        }
    }

    @PostMapping(path = "/update/{id}")
    public String updateStudentById(@PathVariable(name = "id") Integer id, @ModelAttribute(name = "student") Student student) throws Exception {
        studentService.updateStudentByID(id,student);
        return "redirect:/";
    }
}
