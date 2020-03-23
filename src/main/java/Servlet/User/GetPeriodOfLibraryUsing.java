package Servlet.User;


import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Period;

@WebServlet("/getPeriodOfLibraryUsing")
public class GetPeriodOfLibraryUsing extends HttpServlet {

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
            int id = Integer.parseInt(req.getParameter("id"));
            Period p = userService.getPeriodOfLibraryUsing(id);
            writer.println("This user is using library for " + p.getYears() + " years " +
                    p.getMonths() + " months " + p.getDays() + " days");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
