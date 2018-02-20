package bd;

import mapping.*;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

//import org.hibernate.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Teacher {
    private static SessionFactory factory;

    public static void main(String[] args) {

        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }

        Teacher teacher = new Teacher();
        System.out.println("sdaasdasd");
        // end of setup

        teacher.listPrzedmioty();
    }

    public void listPrzedmioty() {
        Session session = factory.openSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            List subjects = session.createQuery("FROM PrzedmiotyEntity").list();
            for (Iterator it = subjects.iterator(); it.hasNext(); ) {
                PrzedmiotyEntity subject = (PrzedmiotyEntity) it.next();
                System.out.println(subject.getNazwa());
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }


}

