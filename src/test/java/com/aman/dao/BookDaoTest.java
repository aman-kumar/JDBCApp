package com.aman.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.Jdbc.DbConfiguration;
import com.aman.domain.Book;

public class BookDaoTest {
	BookDao bookDao = new BookDao();

	@BeforeClass
	public static void setUp() throws Exception {
		DbConfiguration.populateSqls();
	}

	@Test
	public void testCreateBook() throws SQLException {
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book1");
		book.setCopies(1);
		book.setName("Effective Java");

		// when
		bookDao.createBook(book);

		// then
		Connection connection = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = connection.prepareStatement("select name from book");

			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = (String) resultSet.getString("name");
				Assert.assertEquals("Effective Java", name);
			}
		} finally {
			connection.close();
		}
	}

	@Test
	public void testListBook() {

		// given
		Book book2 = new Book();
		book2.setName("Head First");
		book2.setAuthor("Kathy Siera");
		book2.setbookId("book2");
		book2.setCopies(1);
		book2.setDescription("Must read for the Java developer");
		book2.setPublisher("OReilly");
		bookDao.createBook(book2);
		Book book3 = new Book();
		book3.setName("Head First");
		book3.setAuthor("Kathy Siera");
		book3.setbookId("book3");
		book3.setCopies(1);
		book3.setDescription("Must read for the Java developer");
		book3.setPublisher("OReilly");
		bookDao.createBook(book3);
		// when
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookDao.listBook();
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select count(*) from book");
			String query = "select count(*) from book";
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Assert.assertEquals(3, result.getInt(1));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testSearchBook() {

		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book4");
		book.setCopies(1);
		book.setDescription("Must read for evry Java developer");
		book.setName("Effective Java");
		book.setPublisher("Sun Microsystem");
		bookDao.createBook(book);

		Book book1 = new Book();
		book1.setAuthor("Joshua Bloch");
		book1.setbookId("book5");
		book1.setCopies(1);
		book1.setDescription("Must read for evry Java developer");
		book1.setName("Effective Java");
		book1.setPublisher("Sun Microsystem");
		bookDao.createBook(book1);

		Book book2 = new Book();
		book2.setName("Effective Java");
		book2.setAuthor("Joshua Bloch");
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("select count(*) from Book where name=? and author=?");
			statement.setString(1, book2.getName());
			statement.setString(2, book2.getAuthor());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				assertEquals(2, result.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@Test
	public void testListSearchedBook() {
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book6");
		book.setCopies(1);
		book.setDescription("Must read for evry Java developer");
		book.setName("Effective Java");
		book.setPublisher("Sun Microsystem");
		bookDao.createBook(book);

		Book book1 = new Book();
		book1.setAuthor("Joshua Bloch");
		book1.setbookId("book6");
		book1.setCopies(1);
		book1.setDescription("Must read for evry Java developer");
		book1.setName("Effective Java");
		book1.setPublisher("Sun Microsystem");
		bookDao.createBook(book1);

		Book book2 = new Book();
		book2.setName("Effective Java");
		book2.setAuthor("Joshua Bloch");
		bookDao.searchBook(book2);
		assertEquals(2, bookDao.listSearchedBook());

	}

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}
}
