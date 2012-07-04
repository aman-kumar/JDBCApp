package com.aman.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RecordTest {
	Record record;

	@Before
	public void setUp() throws Exception {
		record = new Record();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetBookRecord() {
		record.setBookRecord("BookRecord1");
		assertEquals("BookRecord1", record.getBookRecord());
	}

	@Test
	public void testSetBookRecord() {
		record.setBookRecord("BookRecord2");
		assertEquals("BookRecord2", record.getBookRecord());
	}

	@Test
	public void testGetBookId() {
		record.setBookId("book1");
		assertEquals("book1", record.getBookId());
	}

	@Test
	public void testSetBookId() {
		record.setBookId("book2");
		assertEquals("book2", record.getBookId());

	}

	@Test
	public void testGetStatus() {
		record.setStatus("issued");
		assertEquals("issued", record.getStatus());
	}

	@Test
	public void testSetStatus() {
		record.setStatus("available");
		assertEquals("available", record.getStatus());

	}

	@Test
	public void testGetStudentId() {
		record.setStudentId("student1");
		assertEquals("student1", record.getStudentId());

	}

	@Test
	public void testSetStudentId() {
		record.setStudentId("student2");
		assertEquals("student2", record.getStudentId());
	}

}
