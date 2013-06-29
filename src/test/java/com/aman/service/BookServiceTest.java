package com.aman.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.aman.Jdbc.DbConfiguration;
import com.aman.dao.BookDao;
import com.aman.domain.Book;

public class BookServiceTest {
	
	BookService service;
	@Mock
	BookDao bookDao;
	@Mock
	Book book;
	@Mock
	Book book1;
	@Mock
	List<Book> bookList;

	@Before
	public void setUp() throws Exception {
		DbConfiguration.populateSqls();
		MockitoAnnotations.initMocks(this);
		service = new BookService();
		bookList.add(book);
		bookList.add(book1);
	}

	@Test
	public void testGetList() {
		when(bookDao.listBook()).thenReturn(bookList);
		System.out.println("Result : " +bookDao.listBook());
		assertNotNull("List should not be null", service.getList());
		verify(bookDao).listBook();
	}

}
