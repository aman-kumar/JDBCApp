package com.aman.dao;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.aman.Jdbc.DbConfiguration;
import com.aman.domain.Student;

public class IssueDaoTest {
	IssueDao issueDao = new IssueDao();
	StudentDao studentDao = new StudentDao();

	@BeforeClass
	public static void setUp() throws Exception {
		DbConfiguration.populateSqls();
	}

	@Test
	public void testSearchStudent() {
		Student student = new Student();
		student.setFirstName("Aman");
		student.setLastName("Kumar");
		student.setAddress("Ghaziabad");
		student.setEmailId("er.amankumar@gmail.com");
		student.setPhoneNumber(9899);
		student.setStudentId("student1");
		studentDao.create(student);
		Student student1 = new Student();
		student1.setFirstName("Abhishake");
		student1.setLastName("Dixit");
		student1.setAddress("Ghaziabad");
		student1.setEmailId("er.amankumar@gmail.com");
		student1.setPhoneNumber(9889);
		student1.setStudentId("student2");
		studentDao.create(student1);

	}

	@Test
	public void testCreateRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateRecord() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRecord() {
		fail("Not yet implemented");
	}

	@AfterClass
	public static void tearDown() throws Exception {
		DbConfiguration.tearDownSchema();
	}

}
