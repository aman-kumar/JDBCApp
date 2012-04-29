package com.aman.service;

import java.util.List;

import com.aman.dao.BookDao;
import com.aman.domain.Book;

public class BookService {
    BookDao bookdao;

    public BookService() {
        bookdao = new BookDao();
    }

    public void create(Book book) {
        bookdao.createBook(book);
    }

    public List<Book> getList() {
        return bookdao.listBook();
    }
}