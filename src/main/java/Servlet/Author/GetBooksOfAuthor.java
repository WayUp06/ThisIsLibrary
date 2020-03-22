package Servlet.Author;

import Service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

@WebServlet("/getBooksOfAuthor")
public class GetBooksOfAuthor extends HttpServlet  {

    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        authorService = new AuthorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try {
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");

            ArrayList<String> list = (ArrayList<String>) authorService.getBooksOfAuthor(name, surname);
            writer = resp.getWriter();
            writer.print("Author " + name + " " + surname + " wrote this books: ");
            String books = String.join(", ", list);
            writer.print(books);
        } finally {
            writer.close();
        }
    }
}
