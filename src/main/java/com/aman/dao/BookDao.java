package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;

public class BookDao {

    public void createBook(Book book) {
        Connection con = ConnectionUtils.getConnection();

        try {

            PreparedStatement statement = populateCreateBookStatement(book, con);

            int result = statement.executeUpdate();
            if (result == 1) {
                System.out.println("Query is sucessfully executed");
            } else {
                System.out.println("Query is not sucessfully executed");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex1) {
                throw new IllegalStateException(ex1);
            }

        }

    }

    private PreparedStatement populateCreateBookStatement(Book book,
            Connection con) throws SQLException {
        String query = "INSERT into bookdetails values(?,?,?,?,?,?)";

        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getGenre());
        statement.setString(4, book.getDescription());
        statement.setString(5, book.getPublisher());
        statement.setInt(6, book.getCopies());
        return statement;
    }

    public List<Book> listBook() {
        Connection con = ConnectionUtils.getConnection();
        Book book = new Book();
        List<Book> bookList = new ArrayList<Book>();
        try {

            String query = "SELECT bookTitle,author,genre,book_description,publisher,noOfCopies";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                book.setTitle(result.getString("bookTitle"));
                book.setAuthor(result.getString("author"));
                book.setGenre(result.getString("genre"));
                book.setDescription(result.getString("book_description"));
                book.setPublisher(result.getString("publisher"));
                book.setCopies(result.getInt("noOfCopies"));
            }
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex2) {
                throw new IllegalStateException(ex2);
            }
        }
        return bookList;
    }

}
