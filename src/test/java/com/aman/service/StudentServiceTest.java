package com.aman.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aman.Jdbc.DbConfiguration;
import com.aman.dao.StudentDao;

import com.aman.domain.Book;
import com.aman.domain.Student;
import java.util.*;

import static org.mockito.Mockito.*;

public class StudentServiceTest {

	StudentService service;
	@Mock
	Student student;
	@Mock
	StudentDao studentDao;

	@Mock
	List<Student> studentList;

	@Before
	public void setUp() throws Exception {
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service = new StudentService();
		studentList.add(student);
	}

	@Test
	public void testGetList() {
		when(studentDao.getList()).thenReturn(studentList);
		assertNotNull("Student List should not be null ", studentDao.getList());
		verify(studentDao).getList();
	}

}
