package com.aman.librarymanagementsystem;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aman.domain.Book;
import com.aman.service.SearchBookService;

/**
 * Servlet implementation class SearchBookDisplay
 */
public class SearchBookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    ResultSet rst;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        execute(request, response);
    }

    // populate the object with the incoming -->call service --> send the
    // response to the view
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        execute(request, response);
    }

    private void execute(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        List<Book> bookList = getSearchedBook(book);
        request.setAttribute("book", bookList);
        RequestDispatcher view = request
                .getRequestDispatcher("SearchDisplayResult.jsp");
        view.forward(request, response);
    }

    private List<Book> getSearchedBook(Book book) {
        SearchBookService bookService = new SearchBookService();
        bookService.search(book);
        List<Book> bookList = new ArrayList<Book>();
        bookList = bookService.getSearcBookList();
        return bookList;
    }

}
