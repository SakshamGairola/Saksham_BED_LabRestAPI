package com.greatlearning.studentMgmt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/error")
public class AccessController {

    @RequestMapping("/403")
    public ModelAndView accessDenied(){
        return new ModelAndView("accessDenied(403)");
    }
}
