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
                // con.close();
            } catch (Exception ex1) {
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

        List<Book> bookList = new ArrayList<Book>();
        try {

            String query = "SELECT bookTitle,author,genre,book_description,publisher,noOfCopies from bookdetails";
            PreparedStatement statement = con.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                while (resultSet.next()) {
                    Book book = new Book();
                    book.setTitle(resultSet.getString("bookTitle"));
                    book.setAuthor(resultSet.getString("author"));
                    book.setGenre(resultSet.getString("genre"));
                    book.setPublisher(resultSet.getString("publisher"));
                    book.setDescription(resultSet.getString("book_description"));
                    book.setCopies(resultSet.getInt("noOfCopies"));

                    bookList.add(book);

                }

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

    List<Book> searchBookList = new ArrayList<Book>();

    public void searchBook(Book book) {
        Connection con = ConnectionUtils.getConnection();
        try {
            String author1 = book.getAuthor();
            String title = book.getTitle();
            String query = "SELECT bookTitle,author,genre,book_description,publisher,noOfCopies from bookdetails WHERE author =? and bookTitle=?";//where bookTitle="
                    //+ title + " and author= " + author  ;
            PreparedStatement statement = con.prepareStatement(query);
            statement.setString(1,book.getAuthor());
            statement.setString(2, book.getTitle());
            ResultSet resultSet = statement.executeQuery();
            boolean bookPresenceStatus = true;

            while (resultSet.next()) {
                bookPresenceStatus = false;
                Book book1 = new Book();
                book1.setTitle(resultSet.getString("bookTitle"));
                book1.setAuthor(resultSet.getString("author"));
                book1.setGenre(resultSet.getString("genre"));
                book1.setDescription(resultSet.getString("book_description"));
                book1.setPublisher(resultSet.getString("publisher"));
                book1.setCopies(resultSet.getInt("noOfCopies"));
                searchBookList.add(book1);
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

    public List<Book> listSearchedBook() {
        return searchBookList;
    }
}
