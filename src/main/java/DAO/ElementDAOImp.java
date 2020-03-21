package DAO;

import main.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class ElementDAOImp <E> implements ElementDAO <E> {

    private Class<E> elementClass;

    public ElementDAOImp() {
    }

    public ElementDAOImp(Class<E> elementClass){
        this.elementClass = elementClass;
    }

    @Override
    public void add(E e) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.save(e);
            transaction.commit();
        }finally{
            if((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public void update(E e) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.update(e);
            transaction.commit();
        }finally{
            if((session != null) && (session.isOpen())) session.close();
        }
    }

    @Override
    public Optional<E> get(long eID) {
        Session session = null;
        E e = null;
        try{
            session = HibernateUtil.getSession();
            e = session.get(elementClass,eID);
        }finally{
            if((session != null) && (session.isOpen())) session.close();
        }
        return (Optional<E>) e;
    }

    @Override
    public Collection<E> getAll() {
        Session session = null;
        List elements = new ArrayList<>();
        try{
            session = HibernateUtil.getSession();
            elements = session.createCriteria(elementClass).list();
        }finally {
            if((session != null) && (session.isOpen())) session.close();
        }
        return elements;
    }

    @Override
    public void delete(E e) {
        Session session = null;
        try{
            session = HibernateUtil.getSession();
            Transaction transaction = session.beginTransaction();
            session.delete(e);
            transaction.commit();
        }finally{
            if((session != null) && (session.isOpen())) session.close();
        }
    }
}
