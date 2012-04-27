package com.aman.service;

import java.util.List;

<<<<<<< HEAD
import com.aman.dao.Bookdao;
import com.aman.domain.Book;

public class BookService {
	Bookdao bookdao;

	public BookService() {
		bookdao = new Bookdao();
	}

	public void create(Book book) {
		bookdao.createBook(book);
	}

	public List<Book> getList() {
		return bookdao.listBook();
	}

=======
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
>>>>>>> ac92d8d9e52992b6e98add095bf9468e4668f509
}
