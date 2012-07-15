package com.aman.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.aman.dao.BookDao;
import com.aman.dao.RecordDao;
import com.aman.domain.Book;
import com.aman.domain.Record;
import static org.mockito.Mockito.*;

public class SearchBookServiceTest {

	BookDao mockedBookDao;
	RecordDao mockedRecordDao;
	Book mockedBook;

	@Before
	public void setUp() throws Exception {
		mockedBookDao = mock(BookDao.class);
		mockedRecordDao = mock(RecordDao.class);
		mockedBook = mock(Book.class);
	}

	@Test
	public void testSearchBookService() {

	}

	@Test
	public void testSearch() {
		mockedBookDao.createBook(mockedBook);
		verify(mockedBookDao).createBook(mockedBook);
	}

	@Test
	public void testSetBookRecordList() {
		List<Book> mockBookList = mock(List.class);
		mockedRecordDao.bookRecordList(mockBookList);
		verify(mockedRecordDao).bookRecordList(mockBookList);
	}

	@Test
	public void testGetSearcRecordList() {
		List<Record> mockBookList = mock(List.class);
		when(mockedRecordDao.getRecordList()).thenReturn(mockBookList);
		verify(mockedRecordDao.getRecordList());
	}

	/*
	 * @Test public void testRecordForIssue() { fail("Not yet implemented"); }
	 */
	@After
	public void tearDown() throws Exception {
	}
}
