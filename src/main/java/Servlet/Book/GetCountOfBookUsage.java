package Servlet.Book;


import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getCountOfBookUsage")
public class GetCountOfBookUsage extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try {
            writer = resp.getWriter();
            String name = req.getParameter("name");
            Long l = bookService.getCountOfBookUsage(name);
            writer.println("This book was used " + l + " times,");
        } finally {
            if (writer != null) writer.close();
        }
    }
}
