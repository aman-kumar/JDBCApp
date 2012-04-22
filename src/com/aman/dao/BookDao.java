package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aman.LibraryManagementSystem.ConnectionUtil;
import com.aman.domain.Book;

public class BookDao {
	
	public void create(Book book){
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = populateCreateBookPreparedStatement(book, con);
			int result = statement.executeUpdate();
			if (result == 1) {
				System.out.println("query sucessfully executed");
			} else {
				System.out.println("query was not sucessfully executed");
			}

		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private PreparedStatement populateCreateBookPreparedStatement(Book book,
			Connection con) throws SQLException {
		PreparedStatement statement = con.prepareStatement("INSERT into bookdetails values(?,?,?,?,?,?)");
		statement.setString(1, book.getTitle());
		statement.setString(2, book.getAuthor());
		statement.setString(3, book.getGenre());
		statement.setString(4, book.getDescription());
		statement.setString(5, book.getPublisher());
		statement.setInt(6, book.getCopies());
		return statement;
	}
	
	public List<Book> listBooks() {
		String sql2 = "SELECT bookTitle, author, book_Description, publisher, genre,noOfCopies from bookdetails";
		List<Book> books = new ArrayList<Book>();
		Connection con = ConnectionUtil.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql2);
		    populateBookList(books, statement);
		} catch (SQLException ex) {
			throw new IllegalStateException(ex);
		} finally{
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return books;
	}

	private void populateBookList(List<Book> books, PreparedStatement statement)
			throws SQLException {
		ResultSet resultSet;
		resultSet = statement.executeQuery();
		while(resultSet.next()){
			Book book = new Book();
			book.setTitle(resultSet.getString("bookTitle"));
			book.setAuthor(resultSet.getString("author"));
			book.setGenre(resultSet.getString("genre"));
			book.setDescription(resultSet.getString("book_description"));
			book.setPublisher(resultSet.getString("publisher"));
			book.setCopies(resultSet.getInt("noOfCopies"));
			books.add(book);
		}
	}
}
