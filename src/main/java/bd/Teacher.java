package bd;

import mapping.*;

import java.util.*;

//import org.hibernate.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class Teacher {
    private static SessionFactory factory;

    private Teacher() {}
    private static class Holder {
        private static final Teacher INSTANCE = new Teacher();
    }

    public static Teacher getInstance() {
        return Holder.INSTANCE;
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
        List<PrzedmiotyEntity> subjects_obj = new ArrayList<>();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            //List subjects = session.createQuery("SELECT  FROM PrzedmiotyEntity INNER JOIN FETCH PrzedmiotyEntity.RealizacjeEntity").list();
            List subjects = session.createQuery("SELECT DISTINCT p FROM PrzedmiotyEntity p JOIN FETCH p.realizacjesByKodPrzedmiotu ").list();

            subjects.forEach((Object sub_tmp) -> {
                PrzedmiotyEntity subject = (PrzedmiotyEntity) sub_tmp;
                subjects_obj.add(subject);
                System.out.println(subject.getNazwa());
                //System.out.println(subject.getRealizacjesByKodPrzedmiotu());
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

    public void listOcenyKoncowe() {
        Transaction tx = null;
        List<OcenyKoncoweEntity> degree_final_obj = new ArrayList<>();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            Query query =session.createQuery("FROM OcenyKoncoweEntity OCK WHERE OCK.kodPrzedmiotu = :subject");
            query.setParameter("subject", "MAT");
            List degree_final_list=query.list();
            //List degree_final_list = session.createQuery("FROM OcenyKoncoweEntity OCK WHERE OCK.kodPrzedmiotu = 'MAT'").list();

            degree_final_list.forEach((Object sub_tmp) -> {
                OcenyKoncoweEntity degree_final = (OcenyKoncoweEntity) sub_tmp;
                degree_final_obj.add(degree_final);
                System.out.print(degree_final.getIdStudenta());
                System.out.print(degree_final.getKodPrzedmiotu());
                System.out.print(degree_final.getOcenaKoncowa());
                System.out.println();

            });
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

}

