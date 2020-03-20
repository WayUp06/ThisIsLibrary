package main;

import DAO.BookDAO;
import DAO.UserDAO;
import org.hibernate.Session;

import java.util.ArrayList;

public class Test{
    public static void main(String[] args) {

        try(Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            UserDAO u = new UserDAO();
            BookDAO bookDAO = new BookDAO();
            /*ArrayList<String> l = bookDAO.getCountOfBookUsageByExamples("Book1");
            for(String s:l) System.out.println(s);*/
            //System.out.println(u.getUserAverageAgeByAuthor("First", "Author1"));
            ArrayList<String> l = u.getDebtorsInPast(1);
            for(String s:l) System.out.println(s);

            session.getTransaction().commit();

        }
        catch(Throwable e){ e.printStackTrace();}
            /*List<Book> list = null;
            try(Session session = HibernateUtil.getSession()) {
                Query query = session.createQuery("FROM Book");
                list = (List<Book>) query.list();
                BookExampleDAO bookExampleDAO = new BookExampleDAO();
                ArrayList<Long> arrayList = (ArrayList<Long>) bookExampleDAO.getBookExampleInfoByBookName("Book2");
                System.out.println("Count of all: " + arrayList.get(0) + " ,count of available: " + arrayList.get(1) + " ,count of using: " + arrayList.get(2));
                AuthorDAO authorDAO = new AuthorDAO();
                ArrayList<String> l = (ArrayList<String>) authorDAO.getBooksOfAuthor("third", "author");
                for (String s : l) System.out.println(l);
            }
            catch (Throwable e) {e.printStackTrace();}



        if(list != null && !list.isEmpty()){
            for(Book book: list) System.out.println(

                    "Назва книжки " + book.getName() + " , автор " +
                    book.getAuthor().getName() + " " + book.getAuthor().getSurname());
        }*/

    }

}
