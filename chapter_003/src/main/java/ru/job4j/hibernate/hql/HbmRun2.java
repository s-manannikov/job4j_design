package ru.job4j.hibernate.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class HbmRun2 {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            /*
            Job job1 = new Job(1, "job1");
            Job job2 = new Job(2, "job2");
            Job job3 = new Job(3, "job3");
            session.save(job1);
            session.save(job2);
            session.save(job3);

            JobBase jobBase = new JobBase(1, "job base 1");
            jobBase.addJob(job1);
            jobBase.addJob(job2);
            jobBase.addJob(job3);
            session.save(jobBase);

            Query query = session.createQuery("update Candidate set jobbase_id = :bId where id = :id")
                    .setParameter("bId", 1)
                    .setParameter("id", 1);
            query.executeUpdate();
            */

            Candidate candidate = session.createQuery(
                    "select distinct c from Candidate c "
                            + "join fetch c.jobBase b "
                            + "join fetch b.jobs "
                            + "where c.id = :id", Candidate.class
            ).setParameter("id", 1).uniqueResult();
            System.out.println(candidate);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
