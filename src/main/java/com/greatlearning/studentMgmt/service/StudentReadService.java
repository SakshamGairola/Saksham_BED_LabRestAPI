package com.greatlearning.studentMgmt.service;

import com.greatlearning.studentMgmt.entity.Student;

import java.util.List;

public interface StudentReadService {

    List<Student> getALlStudents();

    Student getStudentById(Long ID);
}
