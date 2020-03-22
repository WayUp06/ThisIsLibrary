package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/getBooksUsedByUser")
public class GetBooksUsedByUser extends HttpServlet {

    private UserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            writer = resp.getWriter();
            String str;
            int id = Integer.parseInt(req.getParameter("id"));
            ArrayList <String> list = userService.getBooksUsedByUser(id);
            String books = String.join(", ",list);
            writer.print("This user used " + books);
        }finally{
            if(writer != null) writer.close();
        }
    }
}
