package com.greatlearning.studentMgmt.controller;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/")
public class StudentReadController {

    @Autowired
    StudentReadService readService;

    @RequestMapping("/")
    public ModelAndView getAllStudents(){
        ModelAndView modelAndView = new ModelAndView("homeView");
        List<Student> allStudents = this.readService.getALlStudents();
        modelAndView.addObject("allStudents", allStudents);
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewStudent(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("invalidView");
        Student student = this.readService.getStudentById(id);
        if(student!=null){
            modelAndView.setViewName("confirmView");
            modelAndView.addObject("studentModel",student);
        }
        return modelAndView;
    }
}
