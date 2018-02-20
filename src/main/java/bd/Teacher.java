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
        Transaction tx = null;

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            List subjects = session.createQuery("FROM PrzedmiotyEntity").list();

            subjects.forEach((Object sub_tmp) -> {
               // PrzedmiotyEntity subject = (PrzedmiotyEntity) sub_tmp;
               // System.out.println(subject.getNazwa());
                System.out.println(((PrzedmiotyEntity) sub_tmp).getNazwa());
            });
//            for (Object subject_tmp : subjects) {
//                PrzedmiotyEntity subject = (PrzedmiotyEntity) subject_tmp;
//                System.out.println(subject.getNazwa());
//            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }


}

