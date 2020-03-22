package Servlet.Book;

import Service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getAverageBookReadingPeriod")
public class GetAverageBookReadingPeriod extends HttpServlet {

    private BookService bookService;

    @Override
    public void init() throws ServletException {
        bookService = new BookService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            String name = req.getParameter("name");
            int i = bookService.getAverageBookReadingPeriod(name);
            writer = resp.getWriter();
            writer.println("It takes " + i + " days to read this book");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
