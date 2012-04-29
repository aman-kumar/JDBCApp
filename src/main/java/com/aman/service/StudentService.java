package com.aman.service;

import java.util.List;

import com.aman.dao.StudentDao;
import com.aman.domain.Student;

public class StudentService {
    StudentDao studentdao;

    public StudentService() {
        new StudentDao();
    }

    public void create(Student student) {
        studentdao.create(student);
    }

    public List<Student> getList() {
        return studentdao.getList();
    }
}
