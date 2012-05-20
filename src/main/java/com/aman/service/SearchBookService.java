package com.aman.service;

import java.util.List;

import com.aman.dao.BookDao;
import com.aman.dao.SearchBookDao;
import com.aman.domain.Book;

public class SearchBookService {
    SearchBookDao searchBookDao;
    BookDao bookDao ;

    public SearchBookService() {
        searchBookDao = new SearchBookDao();
    bookDao=new BookDao();
    }

    public void search(Book book) {
        bookDao.searchBook(book);
    }

    public List<Book> getSearcBookList() {
        return bookDao.listSearchedBook();
    }
}
