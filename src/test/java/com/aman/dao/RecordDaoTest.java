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
import com.aman.domain.Student;

public class RecordDaoTest {
	RecordDao recordDao = new RecordDao();
	BookDao bookDao = new BookDao();
    StudentDao studentDao=new StudentDao();
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
		assertEquals(2, recordDao.listRecord().size());

	}

	@Test
	public void testCreateSearchRecord() {
		// create the record --> enter it to the BookRecord-->
		// createSearchRecord--> call getSearcchedRecordList --> compare it's
		// size
		Record record3 = new Record();
		record3.setBookId("book8");
		record3.setBookRecord("bookRecord4");
		record3.setStatus("available");
		record3.setStudentId("");
		recordDao.createRecord(record3);
		recordDao.createSearchRecord(record3);
		assertEquals(1, recordDao.getSearchedRecordList().size());

	}

	@Test
	public void testGetSearchedRecordList() {
		Record record4 = new Record();
		record4.setBookId("book8");
		record4.setBookRecord("bookRecord5");
		record4.setStatus("available");
		record4.setStudentId("");
		recordDao.createRecord(record4);
		recordDao.createSearchRecord(record4);
		assertEquals(1, recordDao.getSearchedRecordList().size());
	}

	
	  @Test public void testUpdateRecord() { 
		// create student--> add to the Student Table -->studentDao.searchStudent()-->studentDao.getSearchStudent()
			//create Record --> add to the record Table -->createSearchRecord(record) --> recordDao.getSearchRecordList()
			//recordDao.updateRecord(studentDao.getSearchStudent(),recordDao.getSearchRecordList());
	//recordDao.getUpdatedRecord();
		  Student student=new Student();
			student.setFirstName("Aman");
			student.setLastName("Kumar");
			student.setAddress("Ghaziabad");
			student.setEmailId("er.amankumar@gmail.com");
			student.setPhoneNumber(9999);
			student.setStudentId("student5");
			studentDao.create(student);
		  studentDao.searchStudent(student);
		  Record record5=new Record();
		  record5.setBookId("book8");
			record5.setBookRecord("bookRecord6");
			record5.setStatus("available");
			record5.setStudentId("");
			recordDao.createRecord(record5);
			recordDao.createSearchRecord(record5);
			recordDao.updateRecord(studentDao.getSearchStudent(), recordDao.getSearchedRecordList());
			Connection con=ConnectionUtils.getConnection();
			PreparedStatement statement;
			try {
				statement = con.prepareStatement("select bookRecordId,bookId,status,studentId from BookRecord where bookRecordId=?");
				statement.setString(1,"bookRecord6");
				ResultSet result = statement.executeQuery();
				while (result.next()) {
			assertEquals("bookRecord6",result.getString("bookRecordId"));
			assertEquals("issued",result.getString("status"));
			assertEquals("student5",result.getString("studentId"));
			assertEquals("book8",result.getString("bookId"));
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
	 * @Test public void testGetRecord() { fail("Not yet implemented"); }
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
