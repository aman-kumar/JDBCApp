package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;
import com.aman.domain.Record;
import com.aman.domain.Student;

public class RecordDao {

	public void createRecord(Record record) {
		Connection con = ConnectionUtils.getConnection();

		try {

			PreparedStatement statement = populateCreateRecordStatement(record,
					con);

			int result = statement.executeUpdate();
			if (result == 1) {
				System.out.println("Query is sucessfully executed");
			} else {
				System.out.println("Query is not sucessfully executed");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				throw new IllegalStateException(ex1);
			}

		}

	}

	private PreparedStatement populateCreateRecordStatement(Record record,
			Connection con) throws SQLException {
		String query = "INSERT into BookRecord values(?,?,?,?)";

		PreparedStatement statement = con.prepareStatement(query);
		statement.setString(1, record.getBookRecord());
		statement.setString(2, record.getBookId());
		statement.setString(3, record.getStatus());
		statement.setString(4, record.getStudentId());
		return statement;
	}

	public List<Record> listRecord() {
		Connection con = ConnectionUtils.getConnection();

		List<Record> recordList = new ArrayList<Record>();
		try {

			String query = "SELECT bookRecordId,bookId,status,studentId from BookRecord";
			PreparedStatement statement = con.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				while (resultSet.next()) {
					Record record = new Record();
					record.setBookRecord(resultSet.getString("bookRecordId"));
					record.setBookId(resultSet.getString("bookId"));
					record.setStatus(resultSet.getString("status"));
					record.setStudentId(resultSet.getString("studentId"));

					recordList.add(record);

				}

			}
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (SQLException ex2) {
				throw new IllegalStateException(ex2);
			}
		}
		return recordList;
	}

	ArrayList<Record> recordList = new ArrayList<Record>();

	public void bookRecordList(List<Book> searchedBookList) {
		List<Book> bookList = new ArrayList<Book>();
		bookList = searchedBookList;
		ArrayList<Book> list = (ArrayList<Book>) bookList;
		Iterator<Book> itr = list.iterator();
		while (itr.hasNext()) {
			Book book = itr.next();
			String bookId = book.getbookId();
			Connection con = ConnectionUtils.getConnection();
			try {

				String query = "SELECT bookRecordId,bookId,status,studentId from BookRecord where bookId=? and status=?";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, bookId);
				statement.setString(2, "available");
				ResultSet resultSet = statement.executeQuery();
				while (resultSet.next()) {
					Record record = new Record();
					record.setBookId(resultSet.getString("bookId"));
					record.setBookRecord(resultSet.getString("bookRecordId"));
					record.setStatus(resultSet.getString("status"));
					record.setStudentId(resultSet.getString("studentId"));
					recordList.add(record);
				}
			} catch (Exception ex) {
				throw new IllegalStateException(ex);
			} finally {
				try {
					con.close();
				} catch (Exception ex1) {
					throw new IllegalStateException(ex1);
				}
			}
		}

	}

	public List<Record> getRecordList() {
		return recordList;
	}

	List<Record> searchedRecordList = new ArrayList<Record>();

	// change the name in the issue Service for createRecord to
	// createSearchBookRecord
	public void createSearchRecord(Record record) {
		// TODO Auto-generated method stub
		List<Record> recordList1 = new ArrayList<Record>();
		Connection con = ConnectionUtils.getConnection();

		String query = "SELECT bookRecordId,bookId,status,studentId from BookRecord where bookRecordId =?";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, record.getBookRecord());
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Record record1 = new Record();
				record1.setBookRecord(resultSet.getString("bookRecordId"));
				record1.setBookId(resultSet.getString("bookId"));
				record1.setStatus(resultSet.getString("status"));
				record1.setStudentId(resultSet.getString("studentId"));
				recordList1.add(record1);
			}
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				throw new IllegalStateException(ex1);
			}
		}
		searchedRecordList = recordList1;
	}

	public List<Record> getSearchedRecordList() {
		return searchedRecordList;
	}

	// update Record will take the two arguemts one as the StudentList and other
	// one is the RecordList recordList1
	public void updateRecord(List<Student> studentList, List<Record> recordList) {
		Student student2 = new Student();
		Record record2 = new Record();
		String studentid;
		Iterator<Student> itr = studentList.iterator();
		while (itr.hasNext()) {
			student2 = (Student) itr.next();
		}
		studentid = student2.getStudentId();
		String bookRecordId;
		Iterator<Record> itr1 = recordList.iterator();
		while (itr1.hasNext()) {
			record2 = (Record) itr1.next();
		}
		bookRecordId = record2.getBookRecord();
		Connection con = ConnectionUtils.getConnection();
		String query = "UPDATE BookRecord set status=?,studentId=? where bookRecordId=? ";
		try {
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, "issued");
			statement.setString(2, student2.getStudentId());
			statement.setString(3, record2.getBookRecord());
			int result = statement.executeUpdate();
		} catch (Exception ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (Exception ex1) {
				throw new IllegalStateException(ex1);
			}
		}
	}

	public List<Record> getRecord() {
		List<Record> recList = new ArrayList<Record>();
		Connection con = ConnectionUtils.getConnection();
		String qury = "SELECT bookRecordId,bookId,status,studentId from BookRecord";
		try {
			PreparedStatement statement = con.prepareStatement(qury);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Record rec = new Record();
				rec.setBookRecord(resultSet.getString("bookRecordId"));
				rec.setBookId(resultSet.getString("bookId"));
				rec.setStatus(resultSet.getString("status"));
				rec.setStudentId(resultSet.getString("studentId"));
				recList.add(rec);
			}
		} catch (Exception ec) {
			throw new IllegalStateException(ec);
		}
		return recList;
	}

}
