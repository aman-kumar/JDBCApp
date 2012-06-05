package com.aman.service;

import java.util.List;

import com.aman.dao.IssueDao;
import com.aman.dao.SearchBookDao;
import com.aman.domain.Book;
import com.aman.domain.Record;
import com.aman.domain.Student;

public class IssueService {
	IssueDao issueDao;
	SearchBookDao searchBookDao;

	public IssueService() {
		issueDao = new IssueDao();
		searchBookDao = new SearchBookDao();
	}

	public void book() {
		// searchBookDao.getSearchedBook();
		// issueDao.createBook(searchBookDao.getSearchedBook());
	}

	public void issueBook() {
		issueDao.issue();
	}

	public List<Book> getBookList() {
		return issueDao.listBook();
	}

	public List<Student> getStudentList() {
		return issueDao.listStudent();
	}

	public void createStudent(Student student) {
		issueDao.createStudent(student);
	}

	public void searchStudent(Student student) {
		issueDao.searchStudent(student);

	}

	public void createRecord(Record record) {
		// TODO Auto-generated method stub
		issueDao.createRecord(record);
	}

}
