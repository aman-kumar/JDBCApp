package com.aman.service;

import java.util.List;

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

}
