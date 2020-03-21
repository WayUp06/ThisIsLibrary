package DAO;

import Entity.Author;
import Entity.Book;
import main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class AuthorDAO extends ElementDAOImp<Author> {
    public AuthorDAO(Class<Author> elementClass) {
        super(elementClass);
    }

    //public AuthorDAO(){}

    /**
     * @param name - name of author
     * @param surname - surname of author
     * @return list of book names of this author
     */
    public List<String> getBooksOfAuthor(String name, String surname){
        Session session = null;
        ArrayList<String> list;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("select b.name From Book  b " +
                    "where b.author_ID = (select author_ID from Author  where name = :name and surname =:surname)");
            query.setParameter("name",name);
            query.setParameter("surname",surname);
            list = (ArrayList<String>) query.list();
        }
        finally{
            if((session != null) && (session.isOpen())) session.close();
        }
        return list;
    }


    /**
     * @return set of books with this coauthor
     */
    public Set<Book> getBooksOfCoauthor(String name, String surname){
        Session session = null;
        Set<Book> b;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("from Author  a where a.name =:name and a.surname =:surname");
            query.setParameter("name", name);
            query.setParameter("surname", surname);
            Author a = (Author) query.uniqueResult();
            b = (Set<Book>) a.getBooks();
        } finally{
            if((session!=null) && session.isOpen()) session.close();
        }
        return b;
    }
}
