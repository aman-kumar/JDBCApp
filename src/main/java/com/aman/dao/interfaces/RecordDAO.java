package com.aman.dao.interfaces;

import java.util.List;

import com.aman.domain.Book;
import com.aman.domain.Record;
import com.aman.domain.Student;

public interface RecordDAO {
	public void createRecord(Record record);

	public void bookRecordList(List<Book> searchedBookList);

	public List<Record> getRecordList();

	public void createSearchRecord(Record record);

	public List<Record> getSearchedRecordList();

	public void updateRecord(List<Student> studentList, List<Record> recordList);

	public List<Record> getRecord();

}
