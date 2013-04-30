package com.aman.dao.interfaces;

import java.util.List;

import com.aman.domain.Student;

public interface StudentDAO {
	public void create(Student student);

	public List<Student> getList();

	public void searchStudent(Student student);

	public List<Student> getSearchStudent();
}
