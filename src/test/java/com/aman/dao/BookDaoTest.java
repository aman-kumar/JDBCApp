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
		bookDao.createBook(book3); // when
		List<Book> bookList = new ArrayList<Book>();
		bookList = bookDao.listBook();
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select count(*) from book");

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
				// TODO Auto-generated catch
				e.printStackTrace();
			}
		}

	}

	@Test
	public void testSearchBook() {

		Book book4 = new Book();
		book4.setAuthor("Joshua Bloch");
		book4.setbookId("book4");
		book4.setCopies(1);
		book4.setDescription("Must read for evry Java developer");
		book4.setName("Effective Java");
		book4.setPublisher("Sun Microsystem");
		bookDao.createBook(book4);

		Book book1 = new Book();
		book1.setAuthor("Joshua Bloch");
		book1.setbookId("book5");
		book1.setCopies(1);
		book1.setDescription("Must read for evry Java developer");
		book1.setName("Effective Java");
		book1.setPublisher("Sun Microsystem");
		bookDao.createBook(book1);

		Book book5 = new Book();
		book5.setName("Effective Java");
		book5.setAuthor("Joshua Bloch");
		// then

		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("select count(*) from Book where name=? and author=?");
			statement.setString(1, book5.getName());
			statement.setString(2, book5.getAuthor());
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				assertEquals(3, result.getInt(1));
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
		Book book6 = new Book();
		book6.setAuthor("Joshua Bloch");
		book6.setbookId("book6");
		book6.setCopies(1);
		book6.setDescription("Must read for evry Java developer");
		book6.setName("Effective Java");
		book6.setPublisher("Sun Microsystem");
		bookDao.createBook(book6);

		Book book7 = new Book();
		book7.setAuthor("Joshua Bloch");
		book7.setbookId("book7");
		book7.setCopies(1);
		book7.setDescription("Must read for evry Java developer");
		book7.setName("Effective Java");
		book7.setPublisher("Sun Microsystem");
		bookDao.createBook(book7);

		Book book8 = new Book();
		book8.setName("Effective Java");
		book8.setAuthor("Joshua Bloch");
		bookDao.searchBook(book8);
		assertEquals(5, bookDao.listSearchedBook().size());
	}

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}
}
