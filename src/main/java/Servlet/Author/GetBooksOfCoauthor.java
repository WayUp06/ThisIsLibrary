package Servlet.Author;

import Entity.Book;
import Service.AuthorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/getBooksOfCoauthor")
public class GetBooksOfCoauthor extends HttpServlet {

    private AuthorService authorService;

    @Override
    public void init() throws ServletException {
        authorService = new AuthorService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = null;
        try{
            String name = req.getParameter("name");
            String surname = req.getParameter("surname");

            ArrayList <Book> books = (ArrayList<Book>) authorService.getBooksOfCoauthor(name, surname);
            writer = resp.getWriter();
            writer.print(name + " " + surname + " was coauthor in this books:");
            ArrayList <String> list = new ArrayList<>();
            for(Book book:books){
                list.add("title: " + book.getName() + " main author: " + book.getAuthor().getName() + " " + book.getAuthor().getSurname());
            }
            writer. print(String.join(", ", list));
        } finally{writer. close();}
    }
}
