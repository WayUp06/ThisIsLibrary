package Servlet.BookExample;

import Service.BookExampleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getBookExampleCountDuringIndependence")
public class GetBookExampleCountDuringIndependence extends HttpServlet {

    private BookExampleService bookExampleService;

    @Override
    public void init() throws ServletException {
        bookExampleService = new BookExampleService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            Long l = bookExampleService.getBookExamplesCountDuringIndependence();
            writer = resp.getWriter();
            writer.println("We have " + l + " book examples published during independence.");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
