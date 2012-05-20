package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;
import com.aman.domain.Student;

public class IssueDao {
    Student student1 = new Student();
    Book book1 = new Book();

    public void createStudent(Student student) {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        Connection con = ConnectionUtils.getConnection();
        String query = "SELECT firstName,lastName,emailId,address,phoneNumber from studentdetails where firstName=? and lastName=?";
                
        try {
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                student1.setFirstName(resultSet.getString("firstName"));
                student1.setLastName(resultSet.getString("lastName"));
                student1.setEmailId(resultSet.getString("emailId"));
                student1.setAddress(resultSet.getString("address"));
                student1.setPhoneNumber(resultSet.getInt("phoneNumber"));

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

    public void createBook(List<Book> bookList) {
        List<Book> bookList1 = new ArrayList<Book>();
        bookList1 = bookList;
        Iterator<Book> iterator = bookList1.iterator();
        book1 = iterator.next();
    }

    public void issue() {
        Connection con = ConnectionUtils.getConnection();
        String query = "INSERT into issuedetails values(?,?,?,?,?,?,?,?,?,?)";
        try {
            issueProcedure(con, query);
        } catch (Exception ex1) {
            throw new IllegalStateException(ex1);
        } finally {
            try {
                con.close();
            } catch (Exception ex2) {
                throw new IllegalStateException(ex2);
            }
        }
    }

    private void issueProcedure(Connection con, String query)
            throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);

        statement.setString(1, book1.getTitle());
        statement.setString(2, book1.getAuthor());
        statement.setString(3, book1.getDescription());
        statement.setString(4, book1.getPublisher());
        statement.setString(5, student1.getFirstName());
        statement.setString(6, student1.getLastName());
        statement.setString(7, student1.getEmailId());
        statement.setInt(8, student1.getPhoneNumber());
        statement.setString(9, student1.getAddress());
        statement.setString(10, book1.getGenre());
        int bookCopies = book1.getCopies();
        if (bookCopies > 0) {
            bookCopies = bookCopies - 1;
        }
        Book book2 = new Book();
        book2.setCopies(bookCopies);

        String query1 = "UPDATE bookdetails set noOfCopies=? where bookTitle=?"
              ;
        //+ book2.getCopies() + " where bookTitle= "
          //      + book1.getTitle();
        PreparedStatement statement1 = con.prepareStatement(query1);
        statement1.setInt(1, book2.getCopies());
        statement1.setString(2, book1.getTitle());
        statement1.executeUpdate();
    }

    public List<Book> listBook() {
        List<Book> bookList = new ArrayList<Book>();
        bookList.add(book1);
        return bookList;
    }

    public List<Student> listStudent() {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        return studentList;
    }
}
// i can use book1 --->student1 to populate the list