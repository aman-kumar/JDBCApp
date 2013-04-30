package com.aman.dao.interfaces;

import java.util.List;

import com.aman.domain.Book;

public interface BookDAO {
	public void createBook(Book book);

	public List<Book> listBook();

	public void searchBook(Book book);

	public List<Book> listSearchedBook();
}
