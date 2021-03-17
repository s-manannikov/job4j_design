package ru.job4j.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.hibernate.models.Brand;
import ru.job4j.hibernate.models.Model;

public class HbmRun {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Model model1 = Model.of("model1");
            Model model2 = Model.of("model2");
            Model model3 = Model.of("model3");
            Model model4 = Model.of("model4");
            Model model5 = Model.of("model5");
            session.save(model1);
            session.save(model2);
            session.save(model3);
            session.save(model4);
            session.save(model5);

            Brand brand = Brand.of("some brand");
            brand.addModels(session.load(Model.class, 1));
            brand.addModels(session.load(Model.class, 2));
            brand.addModels(session.load(Model.class, 3));
            brand.addModels(session.load(Model.class, 4));
            brand.addModels(session.load(Model.class, 5));
            session.save(brand);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}