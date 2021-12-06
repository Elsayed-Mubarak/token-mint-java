/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asc.dataaccess;

/**
 *
 * @author kamal
 */
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAO {

    protected DAO() {
    }

    private static SessionFactory configure()
    {
        Configuration conf = new Configuration();
        URL u = ClassLoader.getSystemResource("configuration/hibernate.cfg.xml");
        return (conf.configure(u).buildSessionFactory());
    }

    public static Session getSession() {
        Session session = (Session) DAO.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            DAO.session.set(session);
        }
        return session;
    }

    protected void begin() {
        getSession().beginTransaction();
    }

    protected void commit() {
        getSession().getTransaction().commit();
    }

    protected void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }
        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        DAO.session.set(null);
    }

    public static void close() {
        getSession().close();
        DAO.session.set(null);
    }
    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal session = new ThreadLocal();
    private static final SessionFactory sessionFactory = configure();
}
