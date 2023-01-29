package com.greatlearning.studentMgmt.controller;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentDeleteService;
import com.greatlearning.studentMgmt.service.StudentReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/delete")
public class StudentDeleteController {

    @Autowired
    StudentReadService readService;

    @Autowired
    StudentDeleteService deleteService;

    @GetMapping("/{id}")
    public ModelAndView deleteStudent(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("invalidView");
        Student student = this.readService.getStudentById(id);
        if (student != null) {
            modelAndView.setViewName("deleteView");
            modelAndView.addObject("deletedStudent", student);
            this.deleteService.deleteStudent(student);
        }
        return modelAndView;
    }
}
