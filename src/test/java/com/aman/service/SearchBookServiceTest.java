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

public class SearchBookServiceTest {

	SearchBookService service;

	Record record = new Record();

	@Mock
	RecordDao recordDao;

	List<Record> recordList = new ArrayList<Record>();

	@Before
	public void setUp() throws Exception {
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service = new SearchBookService();
		recordList.add(record);
	}

	@Test
	public void testGetSearchList() {
		when(recordDao.getRecordList()).thenReturn(recordList);
		assertNotNull("Record List should not be null",
				recordDao.getRecordList());
		verify(recordDao).getRecordList();
	}
}
