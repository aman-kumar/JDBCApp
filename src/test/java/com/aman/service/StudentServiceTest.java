package com.aman.service;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.aman.dao.StudentDao;

import com.aman.domain.Book;
import com.aman.domain.Student;
import java.util.*;
import static org.mockito.Mockito.*;

public class StudentServiceTest {
	private StudentService studentService;
	StudentDao mockedDao;
	Student mockedStudent;

	@Before
	public void setUp() throws Exception {
		mockedDao = mock(StudentDao.class);
		mockedStudent = mock(Student.class);
	}

	// studentdao.create(student);
	// return studentdao.getList();
	@Test
	public void testStudentService() {
		mockedDao.create(mockedStudent);
		verify(mockedDao).create(mockedStudent);
		List<Student> mockList = mock(List.class);
		when(mockedDao.getList())
				.thenReturn( mockList);
		verify(mockedDao.getList());
	}

	@After
	public void tearDown() throws Exception {
	}

}
