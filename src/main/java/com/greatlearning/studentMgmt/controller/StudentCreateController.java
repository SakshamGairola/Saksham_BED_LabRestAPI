package com.greatlearning.studentMgmt.controller;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/create")
public class StudentCreateController {

    @Autowired
    StudentCreateService createService;

    @GetMapping("/new")
    public ModelAndView getNewStudentForm() {
        ModelAndView modelAndView = new ModelAndView("createNewStudentView");
        modelAndView.addObject("studentModel", new Student());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView saveNewStudent(@ModelAttribute Student student){
        ModelAndView modelAndView = new ModelAndView("confirmView");
        modelAndView.addObject("studentModel", student);
        this.createService.saveStudent(student);
        return modelAndView;
    }
}
