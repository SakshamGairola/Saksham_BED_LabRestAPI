package com.greatlearning.studentMgmt.serviceImpl;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.repository.StudentRepository;
import com.greatlearning.studentMgmt.service.StudentCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCreateServiceImpl implements StudentCreateService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        this.studentRepository.save(student);
    }
}
