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
        System.out.println("setup completed");
    }

    public ArrayList listPrzedmioty() {
        Transaction tx = null;
        ArrayList<PrzedmiotyEntity> subjects_obj = new ArrayList<>();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            //List subjects = session.createQuery("SELECT  FROM PrzedmiotyEntity INNER JOIN FETCH PrzedmiotyEntity.RealizacjeEntity").list();
            List subjects = session.createQuery("SELECT DISTINCT p FROM PrzedmiotyEntity p JOIN FETCH p.realizacjesByKodPrzedmiotu ").list();

            subjects.forEach((Object sub_tmp) -> {
                PrzedmiotyEntity subject = (PrzedmiotyEntity) sub_tmp;
                subjects_obj.add(subject);
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

    public ArrayList listOcenyKoncowe(String subject, long year, String term) {
        Transaction tx = null;
        ArrayList<OcenyKoncoweEntity> degree_final_obj = new ArrayList<>();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            Query query =session.createQuery("FROM OcenyKoncoweEntity OCK JOIN FETCH OCK.studenciByIdStudenta WHERE OCK.kodPrzedmiotu = :subject AND OCK.rok = :year AND OCK.rodzajSemestru = :term");
            query.setParameter("subject", subject);
            query.setParameter("year",  year);;
            query.setParameter("term", term);
            List degree_final_list=query.list();
            //List degree_final_list = session.createQuery("FROM OcenyKoncoweEntity OCK WHERE OCK.kodPrzedmiotu = 'MAT'").list();
            degree_final_list.forEach((Object sub_tmp) -> {
                OcenyKoncoweEntity degree_final = (OcenyKoncoweEntity) sub_tmp;
                degree_final_obj.add(degree_final);
//                System.out.print(degree_final.getIdStudenta());
//                System.out.print(degree_final.getKodPrzedmiotu());
//                System.out.print(degree_final.getOcenaKoncowa());
//                System.out.println();
//                System.out.print(degree_final.getStudenciByIdStudenta().getNrAlbumu());
//                System.out.println();

            });
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return degree_final_obj;
    }

    public ArrayList listOceny(String subject, long year, String term, int idStud ) {
        Transaction tx = null;
        ArrayList<OcenyEntity> degree_final_obj = new ArrayList<>();

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();

            Query query =session.createQuery("FROM OcenyEntity OC JOIN FETCH OC.typyOcenByIdTypuOceny WHERE OC.kodPrzedmiotu = :subject AND OC.rok = :year AND OC.rodzajSemestru = :term AND OC.idStudenta= :idStud");
            query.setParameter("subject", subject);
            query.setParameter("year",  year);;
            query.setParameter("term", term);
            query.setParameter("idStud", idStud);

            List degree_final_list=query.list();
            degree_final_list.forEach((Object sub_tmp) -> {
                OcenyEntity degree_final = (OcenyEntity) sub_tmp;
                degree_final_obj.add(degree_final);
            });
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
        return degree_final_obj;
    }

    public void updateDegree(long ocenyEntityId,String comment ) {

        Transaction tx = null;

        try (Session session = factory.openSession()) {
            tx = session.beginTransaction();
            OcenyEntity ocenyEntity =(OcenyEntity) session.get(OcenyEntity.class,ocenyEntityId);
            ocenyEntity.setKomentarz(comment);
            session.update(ocenyEntity);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

}

