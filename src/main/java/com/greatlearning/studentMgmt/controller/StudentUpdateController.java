package com.greatlearning.studentMgmt.controller;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentReadService;
import com.greatlearning.studentMgmt.service.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/edit")
public class StudentUpdateController {

    @Autowired
    StudentReadService readService;

    @Autowired
    StudentUpdateService updateService;

    @GetMapping("/{id}")
    public ModelAndView getUpdateForm(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("invalidView");
        Student student = this.readService.getStudentById(id);
        if(student!=null) {
            modelAndView.setViewName("editStudentView");
            modelAndView.addObject("student", student);
        }
        return modelAndView;
    }

    @PostMapping("/{id}")
    public ModelAndView updateStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("confirmView");
        modelAndView.addObject("studentModel", student);
        this.updateService.updateStudent(student);
        return modelAndView;
    }
}
