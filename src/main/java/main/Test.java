package main;

import DAO.AuthorDAO;
import DAO.BookDAO;
import DAO.UserDAO;
import Entity.Author;
import Entity.Book;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Set;

public class Test{
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            UserDAO u = new UserDAO();
            System.out.println(u.getPeriodOfLibraryUsing(8));
            /*ArrayList<String> l = bookDAO.getCountOfBookUsageByExamples("Book1");
            for(String s:l) System.out.println(s);*/
            //System.out.println(u.getUserAverageAgeByAuthor("First", "Author1"));
            //ArrayList<String> l = u.getDebtorsInPast(1);
            //for(String s:l) System.out.println(s);
            System.out.println("test");
            session.getTransaction().commit();
            session.close();
        }
        catch(Throwable e){ e.printStackTrace();}


    }

}
