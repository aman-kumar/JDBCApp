package com.aman.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aman.Jdbc.DbConfiguration;
import com.aman.dao.BookDao;
import com.aman.dao.RecordDao;
import com.aman.domain.Book;
import com.aman.domain.Record;
import static org.mockito.Mockito.*;

public class SearchBookServiceTest {
	
	SearchBookService service;
	@Mock
	Record record;

	@Mock
	RecordDao recordDao;

	@Mock
	List<Record> recordList;

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
