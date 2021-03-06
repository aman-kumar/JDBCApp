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
import com.aman.dao.RecordDao;
import com.aman.dao.StudentDao;
import com.aman.domain.Record;
import com.aman.domain.Student;

public class IssueServiceTest {

	IssueService service;

	Record record = new Record();

	Student student = new Student();

	List<Record> recordList = new ArrayList<Record>();
	List<Student> studentList = new ArrayList<Student>();
	@Mock
	RecordDao recordDao;

	@Mock
	StudentDao studentDao;

	@Before
	public void setUp() throws Exception {
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service = new IssueService();
		studentList.add(student);
		recordList.add(record);

	}

	@Test
	public void testGetUpdatedRecord() {
		when(studentDao.getSearchStudent()).thenReturn(studentList);
		when(recordDao.getRecord()).thenReturn(recordList);
		List<Student> list1 = studentDao.getSearchStudent();
		List<Record> list = recordDao.getRecord();
		assertNotNull("The Student list is not null", service.getStudent());
		assertNotNull("The Record list is not null", service.getRecord());
		verify(studentDao).getSearchStudent();
		verify(recordDao).getRecord();
	}
}
