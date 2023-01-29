package com.greatlearning.studentMgmt.serviceImpl;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.repository.StudentRepository;
import com.greatlearning.studentMgmt.service.StudentDeleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentDeleteServiceImpl implements StudentDeleteService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void deleteStudent(Student student) {
        this.studentRepository.delete(student);
    }
}
