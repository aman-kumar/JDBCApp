package com.aman.service;

import java.util.ArrayList;
import java.util.List;

import com.aman.dao.RecordDao;
import com.aman.dao.StudentDao;
import com.aman.domain.Record;
import com.aman.domain.Student;

public class IssueService {
	List<Student> searchList = new ArrayList<Student>();

	StudentDao studentDao;
	RecordDao recordDao;

	public IssueService() {

		studentDao = new StudentDao();
		recordDao = new RecordDao();
	}

	public void SearchStudent(Student student) {
		studentDao.searchStudent(student);
	}

	public List<Student> getStudent() {
		List<Student> searchStudent = studentDao.getSearchStudent();
		return searchStudent;
	}

	public void createRecord(Record record) {
		recordDao.createSearchRecord(record);
	}

	public List<Record> getRecord() {
		List<Record> searchRecord = recordDao.getSearchedRecordList();
		return searchRecord;
	}

	// now both above list will go as the argument to the to the update Record
	public void updateRecord() {
		recordDao.updateRecord(this.getStudent(), this.getRecord());

	}

	public List<Record> getUpdatedRecord() {
		List<Record> recordList = new ArrayList<Record>();
		recordList = recordDao.getRecord();
		return recordList;
	}

}
