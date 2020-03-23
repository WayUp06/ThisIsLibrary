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

@WebServlet("/getTodayDebtors")
public class GetTodayDebtors extends HttpServlet {

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
            long t = Long.parseLong(req.getParameter("t"));
            ArrayList<String> list = userService.getTodayDebtors(t);
            writer.println("Today's debtors are: " + String.join(", ",list));
        }finally{
            if(writer != null) writer.close();
        }
    }
}
