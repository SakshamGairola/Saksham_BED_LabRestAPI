package com.greatlearning.studentMgmt.serviceImpl;

import com.greatlearning.studentMgmt.entity.Student;
import com.greatlearning.studentMgmt.repository.StudentRepository;
import com.greatlearning.studentMgmt.service.StudentReadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentReadServiceImpl implements StudentReadService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> getALlStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long ID) {
        Student student = null;
        try {
            student = this.studentRepository.findById(ID).get();
        } catch (Exception e) {
            System.out.println("Invalid student ID:" + ID + ". Student record does not exist.");
        } finally {
            return student;
        }
    }
}
