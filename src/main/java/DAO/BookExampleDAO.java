package DAO;

import Entity.BookExample;
import main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookExampleDAO extends ElementDAOImp<BookExample> {
    public BookExampleDAO(Class<BookExample> elementClass) {
        super(elementClass);
    }

    public BookExampleDAO(){}


    /**
     *
     * @return count of book examples published after 1991, exclusive
     */
    public Long getBookExamplesCountDuringIndependence(){
        Session session = null;
        Long count;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("Select count(year) as result From BookExample " +
                    " where year > 1991 ");
            count = (Long)query.uniqueResult();


        } finally{
            if((session != null) && (session.isOpen())) session.close();
        }
        if (count != null) return count;
        return 0L;

    }
    /**
     * @return List(count of all examples, count of available examples, count of examples in usage)
     */

    public List<Long> getBookExampleInfoByBookName(String name){
        Session session = null;
        ArrayList<Long> list = new ArrayList<>();
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("select count(be.bookExample_ID) from BookExample be where " +
                    " be.book_ID = (select b.book_ID from Book b where b.name = :name)");
            query.setParameter("name", name);
            long all = (long)query.uniqueResult();
            query = session.createQuery("select count(be.bookExample_ID) from BookExample be where " +
                    " be.existence = 'Yes' and " +
                    "be.book_ID = (select b.book_ID from Book b where b.name = :name)");
            query.setParameter("name",name);
            long available = (long)query.uniqueResult();
            list.add(all);
            list.add(available);
            list.add(all - available);
        }finally {
            if((session != null) && session.isOpen()) session.close();
        }
        return list;
    }
}
