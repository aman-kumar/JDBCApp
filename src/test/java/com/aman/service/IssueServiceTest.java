package com.aman.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aman.dao.RecordDao;
import com.aman.dao.StudentDao;
import com.aman.domain.Record;
import com.aman.domain.Student;

import static org.mockito.Mockito.*;

public class IssueServiceTest {
	RecordDao mockedRecordDao;
	StudentDao mockedStudentDao;

	@Before
	public void setUp() throws Exception {
		mockedRecordDao = mock(RecordDao.class);
		mockedStudentDao = mock(StudentDao.class);
	}

	@Test
	public void testIssueService() {

	}

	@Test
	public void testSearchStudent() {
		Student mockedStudent = mock(Student.class);
		mockedStudentDao.searchStudent(mockedStudent);
		verify(mockedStudentDao).searchStudent(mockedStudent);
	}

	@Test
	public void testCreateRecord() {
		Record mockedRecord = mock(Record.class);
		mockedRecordDao.createSearchRecord(mockedRecord);
		verify(mockedRecordDao).createSearchRecord(mockedRecord);
	}

	@Test
	public void testUpdateRecord() {
		List<Record> searchRecord = mock(List.class);
		List<Student> searchStudent = mock(List.class);
		mockedRecordDao.updateRecord(searchStudent, searchRecord);
		verify(mockedRecordDao).updateRecord(searchStudent, searchRecord);

	}

	@Test
	public void testGetUpdatedRecord() {
		List<Record> mockedrecordList = mock(List.class);
		when(mockedRecordDao.getRecord()).thenReturn(mockedrecordList);
		verify(mockedRecordDao.getRecord());
	}

	@After
	public void tearDown() throws Exception {
	}

}
