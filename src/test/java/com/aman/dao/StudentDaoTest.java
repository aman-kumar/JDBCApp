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
import com.aman.domain.Student;

public class StudentDaoTest {
	StudentDao studentDao = new StudentDao();

	@BeforeClass
	public static void setUp() throws Exception {
		DbConfiguration.populateSqls();
	}

	@Test
	public void testCreate() {
		// given --> student
		Student student = new Student();
		student.setFirstName("Aman");
		student.setLastName("Kumar");
		student.setAddress("Ghaziabad");
		student.setEmailId("er.amankumar@gmail.com");
		student.setPhoneNumber(9999);
		student.setStudentId("student1");
		// when
		studentDao.create(student);
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("select firstName,studentId from student");
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String name = (String) resultSet.getString("firstName");
				String id = (String) resultSet.getString("studentId");
				assertEquals("Aman", name);
				assertEquals("student1", id);
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
	public void testGetList() {
		// given
		Student student1 = new Student();
		student1.setFirstName("Aman");
		student1.setLastName("Kumar");
		student1.setAddress("Ghaziabad");
		student1.setEmailId("er.amankumar@gmail.com");
		student1.setPhoneNumber(9999);
		student1.setStudentId("student2");
		// when
		studentDao.create(student1);
		// then
		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;

		try {
			statement = con.prepareStatement("select count(*) from student");
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
	public void testSearchStudent() {
		Student student2 = new Student();

		student2.setFirstName("Aman");
		student2.setLastName("Kumar");
		student2.setAddress("Ghaziabad");
		student2.setEmailId("er.amankumar@gmail.com");
		student2.setPhoneNumber(9999);
		student2.setStudentId("student3");
		studentDao.create(student2);

		Student student3 = new Student();

		student3.setFirstName("Abhishake");
		student3.setLastName("Dixit");
		student3.setAddress("Gurgaon");
		student3.setEmailId("abhishak.dixit@gmail.com");
		student3.setPhoneNumber(8888);
		student3.setStudentId("student4");
		studentDao.create(student3);

		Student student4 = new Student();
		student4.setFirstName("Aman");
		student4.setLastName("Kumar");
		// then

		Connection con = ConnectionUtils.getConnection();
		PreparedStatement statement;
		try {
			statement = con
					.prepareStatement("select count(*) from Student where firstName=? and lastName=?");
			statement.setString(1, student4.getFirstName());
			statement.setString(2, student4.getLastName());
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
	public void testGetSearchStudent() {
		Student student5 = new Student();

		student5.setFirstName("Aman");
		student5.setLastName("Kumar");
		student5.setAddress("Ghaziabad");
		student5.setEmailId("er.amankumar@gmail.com");
		student5.setPhoneNumber(9999);
		student5.setStudentId("student5");
		studentDao.create(student5);
		Student student6 = new Student();
		student6.setFirstName("Abhishake");
		student6.setLastName("Dixit");
		studentDao.searchStudent(student6);
		assertEquals(1, studentDao.getSearchStudent().size());

	}

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();

	}

}
