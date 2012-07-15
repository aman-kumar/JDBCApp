package com.aman.service;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aman.dao.RecordDao;
import com.aman.domain.Record;

public class RecordServiceTest {
	RecordDao mockedRecordDao;

	@Before
	public void setUp() throws Exception {
		mockedRecordDao = mock(RecordDao.class);
	}

	@Test
	public void testRecordService() {

	}

	@Test
	public void testCreate() {
		Record mockedRecord = mock(Record.class);
		mockedRecordDao.createRecord(mockedRecord);
		verify(mockedRecordDao).createRecord(mockedRecord);
	}

	@Test
	public void testGetList() {
		List<Record> mockedRecordList = mock(List.class);
		when(mockedRecordDao.getRecordList()).thenReturn(mockedRecordList);
		verify(mockedRecordDao.getRecordList());
	}

	@After
	public void tearDown() throws Exception {
	}
}
