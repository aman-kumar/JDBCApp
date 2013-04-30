package com.aman.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.dao.BookDao;
import com.aman.domain.Book;

import static org.mockito.Mockito.*;

public class BookServiceTest {
	/*
	private BookService bookService;
	static BookDao mockedDao;
	static Book mockedBook;

	@BeforeClass
	public static void setUp() throws Exception {
		mockedDao = mock(BookDao.class);
		mockedBook = mock(Book.class);

	}

	/*
	 * public List<Book> getList() { return bookdao.listBook(); }
	 */
/*
	@Test
	public void testBookService() {
		mockedDao.createBook(mockedBook);
		verify(mockedDao).createBook(mockedBook);
		List<Book> mockList = mock(List.class);
		when(mockedDao.listBook()).thenReturn(mockList);
		verify(mockedDao.listBook());
	}

	@After
	public void tearDown() throws Exception {
	}
	*/
}
