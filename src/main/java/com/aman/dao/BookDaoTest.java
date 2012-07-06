package com.aman.dao;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	public static void setup() throws SQLException {
		DbConfiguration.populateSqls();
	}

	@Test
	public void testCreateBook() throws SQLException {
		//given
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book1");
		book.setCopies(1);
		book.setName("Effective Java");
		
		//when
		bookDao.createBook(book);
		
		//then
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
		fail("Not yet implemented");
	}

	@Test
	public void testSearchBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testListSearchedBook() {
		fail("Not yet implemented");
	}
	
	@AfterClass
	public static void tearDown() {
		DbConfiguration.tearDownSchema();
	}

}
