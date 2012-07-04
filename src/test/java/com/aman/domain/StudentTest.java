package com.aman.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StudentTest {
	Student student;

	@Before
	public void setUp() throws Exception {
		student = new Student();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetStudentId() {
		student.setStudentId("student1");
		assertEquals("student1", student.getStudentId());
	}

	@Test
	public void testSetStudentId() {
		student.setStudentId("student2");
		assertEquals("student2", student.getStudentId());
	}

	@Test
	public void testGetFirstName() {
		student.setFirstName("Aman");
		assertEquals("Aman", student.getFirstName());
	}

	@Test
	public void testSetFirstName() {
		student.setFirstName("Abhishake");
		assertEquals("Abhishake", student.getFirstName());
	}

	@Test
	public void testGetLastName() {
		student.setLastName("Dhiman");
		assertEquals("Dhiman", student.getLastName());
	}

	@Test
	public void testSetLastName() {
		student.setLastName("Dixit");
		assertEquals("Dixit", student.getLastName());
	}

	@Test
	public void testGetEmailId() {
		student.setEmailId("er.amankumar@gmail.com");
		assertEquals("er.amankumar@gmail.com", student.getEmailId());
	}

	@Test
	public void testSetEmailId() {
		student.setEmailId("abhishake.dixit@gmail.com");
		assertEquals("abhishake.dixit@gmail.com", student.getEmailId());
	}

	@Test
	public void testGetAddress() {
		student.setAddress("Ghaziabad");
		assertEquals("Ghaziabad", student.getAddress());
	}

	@Test
	public void testSetAddress() {
		student.setAddress("Gurgaon");
		assertEquals("Gurgaon", student.getAddress());
	}

	@Test
	public void testGetPhoneNumber() {
		student.setPhoneNumber(989926);
		assertEquals(989926, student.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumberInt() {
		student.setPhoneNumber(98888);
		assertEquals(98888, student.getPhoneNumber());
	}

}
