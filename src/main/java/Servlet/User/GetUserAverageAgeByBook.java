package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUserAverageAgeByBook")
public class GetUserAverageAgeByBook extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            String name = req.getParameter("name");
            Double d = userService.getUserAverageAgeByBook(name);
            writer.println("Average age by this book is " + d);
        } finally{
            if(writer != null) writer.close();
        }
    }
}
