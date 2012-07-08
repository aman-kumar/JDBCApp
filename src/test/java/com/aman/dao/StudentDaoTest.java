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
	public void testCreate() throws SQLException {
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
			statement = con.prepareStatement("select firstName,studentId from student");
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

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
