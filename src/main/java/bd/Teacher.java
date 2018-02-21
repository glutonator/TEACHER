package bd;

import app_logic.TeacherWindow;
import mapping.*;

import java.util.ArrayList;
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

//        new Thread( ()-> TeacherWindow.main(null)).start();
//        Teacher teacher = new Teacher();
//        teacher.setup();
//        teacher.listPrzedmioty();
    }

    public void setup () {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        System.out.println("sdaasdasd");
    }

    public List listPrzedmioty() {
        Transaction tx = null;
        List subjects_obj = new ArrayList();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            List subjects = session.createQuery("FROM PrzedmiotyEntity").list();

            subjects.forEach((Object sub_tmp) -> {
                PrzedmiotyEntity subject = (PrzedmiotyEntity) sub_tmp;
                subjects_obj.add(subject);
                System.out.println(subject.getNazwa());
                //System.out.println(((PrzedmiotyEntity) sub_tmp).getNazwa());
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
        return subjects_obj;
    }


}

