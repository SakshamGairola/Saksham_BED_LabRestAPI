package com.greatlearning.studentMgmt.serviceImpl;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.service.StudentCreateService;
import com.greatlearning.studentMgmt.service.StudentUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentUpdateServiceImpl implements StudentUpdateService {

    @Autowired
    StudentCreateService createService;

    @Override
    public void updateStudent(Student student) {
        this.createService.saveStudent(student);
    }
}
