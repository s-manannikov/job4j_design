package ru.job4j.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.math.BigDecimal;
import java.util.List;

public class HbmRun {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            /*
            Candidate one = new Candidate(1, "name1", "experience1", new BigDecimal("100000"));
            Candidate two = new Candidate(2, "name2", "experience2", new BigDecimal("200000"));
            Candidate three = new Candidate(3, "name3", "experience3", new BigDecimal("300000"));

            session.save(one);
            session.save(two);
            session.save(three);
             */

            Query query1 = session.createQuery("from Candidate where id = :id")
                    .setParameter("id", 1);
            System.out.println(query1.uniqueResult());

            Query query2 = session.createQuery("from Candidate where name = :name")
                    .setParameter("name", "name2");
            System.out.println(query2.uniqueResult());

            Query query3 = session.createQuery("update Candidate set name = :name, experience = :experience, salary = :salary where id = :id")
                    .setParameter("name", "name11")
                    .setParameter("experience", "experience11")
                    .setParameter("salary", new BigDecimal("111111"))
                    .setParameter("id", 1);
            query3.executeUpdate();

            Query query4 = session.createQuery("delete from Candidate where id = :id")
                    .setParameter("id", 3);
            query4.executeUpdate();

            List list = session.createQuery("from Candidate").list();
            System.out.println(list);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}