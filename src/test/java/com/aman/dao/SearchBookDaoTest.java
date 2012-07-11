package com.aman.dao;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.Jdbc.DbConfiguration;
import com.aman.domain.Book;
import com.aman.domain.Record;

public class SearchBookDaoTest {
	//SearchBookDao searchBookDao = new SearchBookDao();
	BookDao bookDao = new BookDao();
	RecordDao recordDao = new RecordDao();

	@BeforeClass
	public static void setUp() throws Exception {
		DbConfiguration.populateSqls();

	}

	@Test
	public void testSearchBook() {
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book1");
		book.setCopies(1);
		book.setDescription("Must read for evry Java developer");
		book.setName("Effective Java");
		book.setPublisher("Sun Microsystem");
		bookDao.createBook(book);

		Book book1 = new Book();
		book1.setAuthor("Joshua Bloch");
		book1.setbookId("book2");
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

	/*
	 * @Test public void testBookRecordList() {
	 * 
	 * }
	 */

	@Test
	public void testGetRecordList() {
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book3");
		book.setCopies(5);
		book.setDescription("Must read for evry Java developer");
		book.setName("Effective Java");
		book.setPublisher("Sun Microsystem");
		bookDao.createBook(book);
		Record record = new Record();
		record.setBookId("book3");
		record.setBookRecord("bookRecord1");
		record.setStatus("issued");
		record.setStudentId("");
		recordDao.createRecord(record);

		Record record1 = new Record();
		record1.setBookId("book3");
		record1.setBookRecord("bookRecord2");
		record1.setStatus("available");
		record1.setStudentId("");
		recordDao.createRecord(record1);
		Record record2 = new Record();
		record2.setBookId("book3");
		record2.setBookRecord("bookRecord3");
		record2.setStatus("available");
		record2.setStudentId("");
		recordDao.createRecord(record2);
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("SELECT count(*) from BookRecord where bookId=? and status=? ");
			
			statement.setString(1, "book3");
			statement.setString(2, "issued");
			ResultSet result = statement.executeQuery();
			//statement.executeUpdate();
			while (result.next()) {
				assertEquals(1, result.getInt(1));

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

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
