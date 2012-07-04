package com.aman.domain;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	Book book;

	@Before
	public void setUp() throws Exception {
		book = new Book();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetName() {
		book.setName("Effective Java");
		assertEquals("Effective Java", book.getName());
	}

	@Test
	public void testSetName() {
		Book book = new Book();
		book.setName("HeadFirst Java");

		assertEquals("HeadFirst Java", book.getName());
	}

	@Test
	public void testGetAuthor() {
		book.setAuthor("Joshua Bloch");
		assertEquals("Joshua Bloch", book.getAuthor());
	}

	@Test
	public void testSetAuthor() {
		book.setAuthor("Kathy Siera");
		assertEquals("Kathy Siera", book.getAuthor());

	}

	@Test
	public void testGetbookId() {
		book.setbookId("book1");
		assertEquals("book1", book.getbookId());
	}

	@Test
	public void testSetbookId() {
		book.setbookId("book2");
		assertEquals("book2", book.getbookId());
	}

	@Test
	public void testGetDescription() {
		book.setDescription("Effective Java is a must read book for Java Developer");
		assertEquals("Effective Java is a must read book for Java Developer",
				book.getDescription());
	}

	@Test
	public void testSetDescription() {
		book.setDescription("Extreme Programming is must read book");
		assertEquals("Extreme Programming is must read book",
				book.getDescription());
	}

	@Test
	public void testSetPublisher() {
		book.setPublisher("OReilly");
		assertEquals("OReilly", book.getPublisher());
	}

	@Test
	public void testGetPublisher() {
		book.setPublisher("Tata Mcgraw");
		assertEquals("Tata Mcgraw", book.getPublisher());
	}

	@Test
	public void testGetCopies() {
		book.setCopies(10);
		assertEquals(10, book.getCopies());
	}

	@Test
	public void testSetCopiesInt() {
		book.setCopies(20);
		assertEquals(20, book.getCopies());
	}

}
