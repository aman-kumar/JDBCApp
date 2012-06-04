package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;
import com.aman.domain.Record;

public class SearchBookDao {

	// what i need to
	// enter name,author of book-->now fetch the bookId from the Book Table now
	// after fetching the BookId --> will fetch the record
	// from the BookRecord of only that book whose status is "available"--> then
	// will display the result in SearchBookResult.jsp"
	// since the book is added now i need to know the the BookId of books and
	// using that book id

	ArrayList<Book> searchBookList;

	public void SearchBook(Book book) {
		// String name=book.getName();
		// String author=book.getAuthor();
		searchBookList = new ArrayList<Book>();
		Connection con = ConnectionUtils.getConnection();
		try {

			String query = "SELECT bookId,name,author,publication,description,noOfCopies from Book WHERE author =? and name=?";// where
																																// bookTitle="
			// + title + " and author= " + author ;
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, book.getAuthor());
			statement.setString(2, book.getName());
			ResultSet resultSet = statement.executeQuery();
			boolean bookPresenceStatus = true;

			while (resultSet.next()) {
				bookPresenceStatus = false;
				Book book1 = new Book();
				book1.setbookId(resultSet.getString("bookId"));
				book1.setName(resultSet.getString("name"));
				book1.setAuthor(resultSet.getString("author"));
				// book1.setGenre(resultSet.getString("genre"));
				book1.setDescription(resultSet.getString("description"));
				book1.setPublisher(resultSet.getString("publication"));
				book1.setCopies(resultSet.getInt("noOfCopies"));
				searchBookList.add(book1);
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

	ArrayList<Record> recordList = new ArrayList<Record>();

	// now have to fetch the bookId from the searchBookList and accordingly get
	// bookRecord and add the contents to the to another List
	public void bookRecordList() {
		ArrayList<Book> list = (ArrayList<Book>) searchBookList;
		Iterator<Book> itr = list.iterator();
		while (itr.hasNext()) {
			Book book = itr.next();
			String bookId = book.getbookId();
			Connection con = ConnectionUtils.getConnection();
			try {

				String query = "SELECT bookRecordId,bookId,status,studentId from BookRecord where bookId=? and status=available";
				PreparedStatement statement = con.prepareStatement(query);
				statement.setString(1, bookId);
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
}
