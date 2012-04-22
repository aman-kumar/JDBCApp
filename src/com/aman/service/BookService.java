package com.aman.service;

import java.util.List;

import com.aman.dao.BookDao;
import com.aman.domain.Book;

public class BookService {
	BookDao bookDao;
	public BookService() {
		bookDao = new BookDao();
	}
	
	public void create(Book book){
		bookDao.create(book);
	}
	
	public List<Book> listBooks(){
		return bookDao.listBooks();
	}
}
