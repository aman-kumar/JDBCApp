package com.aman.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aman.Jdbc.DbConfiguration;
import com.aman.dao.StudentDao;
import com.aman.domain.Student;

public class StudentServiceTest {

	StudentService service;

	Student student = new Student();
	@Mock
	StudentDao studentDao;

	List<Student> studentList = new ArrayList<Student>();

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
