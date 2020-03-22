package Servlet.Usage;


import Service.UsageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/getCountOfUsagesOfPeriod")
public class GetCountOfUsagesOfPeriod extends HttpServlet {

    private UsageService usageService;

    @Override
    public void init() throws ServletException {
        usageService = new UsageService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            String start = req.getParameter("start");
            String end = req.getParameter("end");
            int i = usageService.getCountOfUsagesOfPeriod(start,end);
            writer = resp.getWriter();
            writer.println("There were " + i + " usages.");
        }finally{
            if(writer != null) writer.close();
        }
    }
}
