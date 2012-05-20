package com.aman.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aman.Jdbc.ConnectionUtils;
import com.aman.domain.Book;

public class SearchBookDao {

    Book book1 = new Book();

    public void searchBook(Book book) {
        // book.getTitle();
        // book.getAuthor();
        Connection con = ConnectionUtils.getConnection();

       // String query = "SELECT bookTitle,author,genre,book_description,publisher,noOfCopies from bookdetails where bookTitle = "+book.getTitle() ;
        String query="select * from bookdetails ";
        try {
            searchingBook(book, con, query);
        } catch (SQLException ex) {
            throw new IllegalStateException(ex);
        } finally {
            try {
                con.close();
            } catch (SQLException ex1) {
                throw new IllegalStateException(ex1);
            }
        }
    }

    private void searchingBook(Book book, Connection con, String query)
            throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
    //    statement.setString(1, book.getTitle());
      //  statement.setString(2, book.getAuthor());
        ResultSet resultset = statement.executeQuery();
        boolean searchResult = true;
        while (resultset.next()) {
            searchResult = false;
            book1.setTitle(resultset.getString("bookTitle"));
            book1.setAuthor(resultset.getString("author"));
            book1.setGenre(resultset.getString("genre"));
            book1.setDescription(resultset.getString("book_description"));
            book1.setPublisher(resultset.getString("publisher"));
            book1.setCopies(resultset.getInt("noOfCopies"));
        }

        if (searchResult) {
            System.out
                    .println("The searched book is not present in the database");
        }
    }

    public List<Book> getSearchedBook() {

        List<Book> searchedBookList = new ArrayList<Book>();
        searchedBookList.add(book1);
        return searchedBookList;
    }
}
