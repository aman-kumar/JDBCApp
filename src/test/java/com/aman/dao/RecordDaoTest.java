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

public class RecordDaoTest {
	RecordDao recordDao = new RecordDao();
	BookDao bookDao = new BookDao();

	@BeforeClass
	public static void setUp() throws Exception {
		DbConfiguration.populateSqls();
	}

	@Test
	public void testCreateRecord() {
		// given
		Book book = new Book();
		book.setAuthor("Joshua Bloch");
		book.setbookId("book1");
		book.setCopies(1);
		book.setDescription("Must read for evry Java developer");
		book.setName("Effective Java");
		book.setPublisher("Sun Microsystem");
		bookDao.createBook(book);
		Record record = new Record();
		record.setBookId("book1");
		record.setBookRecord("bookRecord1");
		record.setStatus("available");
		record.setStudentId("student1");
		// when
		recordDao.createRecord(record);
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("select bookRecordId,bookId,status,studentId from BookRecord");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				String recordId = result.getString("bookRecordId");
				assertEquals("bookRecord1", recordId);
				String bookId = result.getString("bookId");
				assertEquals("book1", bookId);
				String status = result.getString("status");
				assertEquals("available", status);
				String studentId = result.getString("studentId");
				assertEquals("student1", studentId);
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
	public void testListRecord() {
		//given
		Book book1 = new Book();
		book1.setAuthor("Joshua Bloch");
		book1.setbookId("book2");
		book1.setCopies(1);
		book1.setDescription("Must read for evry Java developer");
		book1.setName("Effective Java");
		book1.setPublisher("Sun Microsystem");
		bookDao.createBook(book1);
		Record record1 = new Record();
		record1.setBookId("book2");
		record1.setBookRecord("bookRecord2");
		record1.setStatus("available");
		record1.setStudentId("student2"); 
		// when
		recordDao.createRecord(record1); 
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("select count(*) from BookRecord");
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

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
