package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Record;

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

	// List<Book> searchBookList = new ArrayList<Book>();

	/*
	 * public void searchBook(Book book) { Connection con =
	 * ConnectionUtils.getConnection(); try { String author1 = book.getAuthor();
	 * String title = book.getName(); String query =
	 * "SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author =? and name=?"
	 * ;//where bookTitle=" //+ title + " and author= " + author ;
	 * PreparedStatement statement = con.prepareStatement(query);
	 * statement.setString(1,book.getAuthor()); statement.setString(2,
	 * book.getName()); ResultSet resultSet = statement.executeQuery(); boolean
	 * bookPresenceStatus = true;
	 * 
	 * while (resultSet.next()) { bookPresenceStatus = false; Book book1 = new
	 * Book(); book1.setbookId(resultSet.getString("bookId"));
	 * book1.setName(resultSet.getString("name"));
	 * book1.setAuthor(resultSet.getString("author")); //
	 * book1.setGenre(resultSet.getString("genre"));
	 * book1.setDescription(resultSet.getString("description"));
	 * book1.setPublisher(resultSet.getString("publication"));
	 * book1.setCopies(resultSet.getInt("noOfCopies"));
	 * searchBookList.add(book1); } } catch (Exception ex) { throw new
	 * IllegalStateException(ex); } finally { try { con.close(); } catch
	 * (Exception ex1) { throw new IllegalStateException(ex1);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * }
	 */

	/*
	 * public List<Book> listSearchedBook() { return searchBookList; }
	 */
}
