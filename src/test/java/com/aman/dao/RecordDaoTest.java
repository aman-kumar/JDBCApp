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
		Book book8 = new Book();
		book8.setAuthor("Joshua Bloch");
		book8.setbookId("book8");
		book8.setCopies(2);
		book8.setDescription("Must read for evry Java developer");
		book8.setName("Effective Java");
		book8.setPublisher("Sun Microsystem");
		bookDao.createBook(book8);
		Record record = new Record();
		record.setBookId("book8");
		record.setBookRecord("bookRecord1");
		record.setStatus("available");
		record.setStudentId("");
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
				assertEquals("book8", bookId);
				String status = result.getString("status");
				assertEquals("available", status);
				String studentId = result.getString("studentId");
				assertEquals("", studentId);
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
		Book book9 = new Book();
		book9.setAuthor("Joshua Bloch");
		book9.setbookId("book9");
		book9.setCopies(1);
		book9.setDescription("Must read for evry Java developer");
		book9.setName("Effective Java");
		book9.setPublisher("Sun Microsystem");
		bookDao.createBook(book9);
		Record record1 = new Record();
		record1.setBookId("book9");
		record1.setBookRecord("bookRecord2");
		record1.setStatus("issued");
		record1.setStudentId("student2");
		// when
		recordDao.createRecord(record1);
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

	@Test
	public void testBookRecordList() {
		Record record2 = new Record();
		record2.setBookId("book8");
		record2.setBookRecord("bookRecord3");
		record2.setStatus("available");
		record2.setStudentId("");
		recordDao.createRecord(record2);
		Connection con = ConnectionUtils.getConnection();
		try {

			String query = "select count(*) from BookRecord where bookId=? and status=?";
			PreparedStatement statement = con.prepareStatement(query);
			statement.setString(1, "book8");
			statement.setString(2, "available");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				assertEquals(2, resultSet.getInt(1));
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

	
	 @Test 
	 public void testGetRecordList() { 
	assertEquals(2,recordDao.listRecord().size()); 
		 
	 }
	

	 @Test 
	 public void testCreateSearchRecord() { 
		 
		
	  }
	 /* 	 * 
	 * @Test public void testGetSearchedRecordList() {
	 * fail("Not yet implemented"); }
	 * 
	 * @Test public void testUpdateRecord() { fail("Not yet implemented"); }
	 * 
	 * @Test public void testGetRecord() { fail("Not yet implemented"); }
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
