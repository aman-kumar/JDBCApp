package com.aman.service;

import java.util.List;

import com.aman.dao.SearchBookDao;
import com.aman.domain.Book;
import com.aman.domain.Record;

public class SearchBookService {
	SearchBookDao searchBookDao;

	public SearchBookService() {
		searchBookDao = new SearchBookDao();
	}

	public void search(Book book) {
		searchBookDao.SearchBook(book);
	}

	public void setBookRecordList() {
		searchBookDao.bookRecordList();
	}

	public List<Record> getSearcRecordList() {
		return searchBookDao.getRecordList();
	}
}
