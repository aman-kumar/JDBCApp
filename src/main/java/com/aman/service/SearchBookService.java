package com.aman.service;

import java.util.List;

import com.aman.dao.SearchBookDao;
import com.aman.domain.Book;

public class SearchBookService {
    SearchBookDao bookdao;

    public SearchBookService() {
        bookdao = new SearchBookDao();
    }

    public void search(Book book) {
        bookdao.searchBook(book);
    }

    public List<Book> getSearcBookList() {
        return bookdao.getSearchedBook();
    }
}
