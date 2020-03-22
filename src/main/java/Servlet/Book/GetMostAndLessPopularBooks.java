package Servlet.Book;


import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/getMostAndLessPopularBooks")
public class GetMostAndLessPopularBooks extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            String start = req.getParameter("start");
            String end = req.getParameter("end");

            ArrayList <String> list = bookService.getMostPopularAndUnpopularBookByPeriod(start,end);
            writer = resp.getWriter();
            writer.println("The most popular book is " + list.get(0) + " and the less popular is " + list.get(1));

        } finally{
            if(writer != null) writer.close();
        }

    }
}
