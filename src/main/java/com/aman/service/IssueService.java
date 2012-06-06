package com.aman.service;

import java.util.ArrayList;
import java.util.List;

import com.aman.dao.IssueDao;
import com.aman.domain.Record;
import com.aman.domain.Student;



public class IssueService {
		IssueDao issueDao;
		public IssueService(){
			issueDao=new IssueDao();
		}
		
		public void SearchStudent(Student student){
			issueDao.searchStudent(student);
		}
		public void createRecord(Record record){
issueDao.createRecord(record);			
		}
		public void updateRecord(){
			issueDao.updateRecord();
		}
		public List<Record> getUpdatedRecord(){
			List<Record> recordList=new ArrayList<Record>();
			recordList=issueDao.getRecord();
			return recordList;
		}
	
}
