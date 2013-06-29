package com.aman.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aman.Jdbc.DbConfiguration;
import com.aman.dao.RecordDao;
import com.aman.domain.Record;

public class RecordServiceTest {
/*
 *    public List<Record> getList() {
        return recorddao.listRecord();
    }
 * 
 */
	
	RecordService service;
	
	@Mock
	RecordDao recordDao;
	
	@Mock
	Record record;
	
	@Mock
	List<Record> recordList;
	
	@Before
	public void setUp() throws Exception{
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service=new RecordService();
		recordList.add(record);
	}
	
	@Test
	
	public void testGetList(){
		when(recordDao.listRecord()).thenReturn(recordList);
		assertNotNull("Record List should not be null ",recordDao.listRecord());
		verify(recordDao).listRecord();
		
	}
}
