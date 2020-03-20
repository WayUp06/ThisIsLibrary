package main;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {


    public static Session getSession() throws HibernateException{

        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(Entity.Author.class);
        configuration.addAnnotatedClass(Entity.Book.class);
        configuration.addAnnotatedClass(Entity.BookExample.class);
        configuration.addAnnotatedClass(Entity.Usage.class);
        configuration.addAnnotatedClass(Entity.User.class);
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                configuration.getProperties()).build();
        SessionFactory mySessionalFactory = configuration.buildSessionFactory(serviceRegistry);
        return mySessionalFactory.openSession();
    }


}
