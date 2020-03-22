package Servlet.BookExample;


import Service.BookExampleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/getBookExampleInfoByBookNmae")
public class GetBookExampleInfoByBookName extends HttpServlet {

    private BookExampleService bookExampleService;

    @Override
    public void init() throws ServletException {
        bookExampleService = new BookExampleService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            writer = resp.getWriter();
            String name = req.getParameter("name");
            ArrayList<Long> list = (ArrayList<Long>) bookExampleService.getBookExampleInfoByBookName(name);
            writer.println("We have " + list.get(0) + " examples of this book. " + list.get(1) + " are available now " +
                    "and " + list.get(2) + " are in use.");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
