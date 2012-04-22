package com.aman.LibraryManagementSystem;

import java.sql.Connection;

public class LibraryManagement {
	Connection con = null;
	QueryExecution qeObject = new QueryExecution();
	ConnectionUtil objdatabasecon = new ConnectionUtil();

	private String bookTitle;
	private String bookAuthor;
	private String bookGenre;
	private String bookDescription;
	private String bookPublisher;
	private Integer bookCopies;
	private String firstName;
	private String lastName;
	private String emailId;
	private String address;
	private Integer phoneNumber;

	public void setBookInfo(String title, String author, String genre,
			String description, String publisher, String copies) {
		bookTitle = title;
		bookAuthor = author;
		bookGenre = genre;
		bookDescription = description;
		bookPublisher = publisher;
		bookCopies = Integer.parseInt(copies);
	}

	public void setStudentInfo(String stFname, String stLname, String stMail,
			String stAddress, Integer stPhonenumber) {
		firstName = stFname;
		lastName = stLname;
		emailId = stMail;
		String address = stAddress;
		phoneNumber = stPhonenumber;
	}

}
