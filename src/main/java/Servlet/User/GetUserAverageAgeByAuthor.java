package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getUserAverageAgeByAuthor")
public class GetUserAverageAgeByAuthor extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer= null;
        try{
            writer =  resp.getWriter();
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");
            double d = userService.getUserAverageAgeByAuthor(name,surname);
            writer.println("Average age by this author is " + d);
        }finally{
            if(writer != null) writer.close();
        }
    }
}
