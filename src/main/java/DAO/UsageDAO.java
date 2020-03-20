package DAO;

import Entity.Usage;
import main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.time.LocalDate;

public class UsageDAO extends ElementDAOImp<Usage> {
    public UsageDAO(Class<Usage> elementClass) {
        super(elementClass);
    }

    public UsageDAO(){}

    /**
     * @return count of all library usages during some period
     */
    public int getCountOfUsagesOfPeriod(String start, String end){
        Session session = null;
        int result;
        try{
            session = HibernateUtil.getSession();
            session.beginTransaction();
            Query query = session.createQuery("select count(u.id) from Usage u" +
                    " where u.takeDate > :start and u.takeDate < :end");
            LocalDate s = LocalDate.parse(start);
            LocalDate e = LocalDate.parse(end);
            query.setParameter("start", s);
            query.setParameter("end", e);
            result = (int) query.uniqueResult();
        }finally{
            if((session != null) && session.isOpen()) session.close();
        }
        return result;
    }
}
