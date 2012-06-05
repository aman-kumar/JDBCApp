package com.aman.service;

import java.util.List;

import com.aman.dao.IssueDao;
import com.aman.dao.SearchBookDao;
import com.aman.domain.Book;
import com.aman.domain.Record;

public class SearchBookService {
	SearchBookDao searchBookDao;
	IssueDao issueDao;

	public SearchBookService() {
		searchBookDao = new SearchBookDao();
		issueDao = new IssueDao();
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

	public void recordForIssue(List<Record> recordList) {
		// TODO Auto-generated method stub
		//issueDao.setRecordForIssue(recordList);
	}
}
