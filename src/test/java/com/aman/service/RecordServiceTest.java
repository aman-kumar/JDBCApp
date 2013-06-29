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
import com.aman.domain.Record;

public class RecordServiceTest {

	RecordService service;

	@Mock
	RecordDao recordDao;

	Record record = new Record();

	List<Record> recordList = new ArrayList<Record>();

	@Before
	public void setUp() throws Exception {
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service = new RecordService();
		recordList.add(record);
	}

	@Test
	public void testGetList() {
		when(recordDao.listRecord()).thenReturn(recordList);
		assertNotNull("Record List should not be null ", recordDao.listRecord());
		verify(recordDao).listRecord();

	}
}
