package ru.job4j.hibernate.run;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.job4j.hibernate.models.Author;
import ru.job4j.hibernate.models.Book;

public class HbmRun2 {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Book book1 = Book.of("book1");
            Book book2 = Book.of("book2");
            Book book3 = Book.of("book3");

            Author one = Author.of("author1");
            one.getBooks().add(book1);
            one.getBooks().add(book2);

            Author two = Author.of("author2");
            two.getBooks().add(book2);
            two.getBooks().add(book3);

            Author three = Author.of("author3");
            three.getBooks().add(book3);

            session.persist(one);
            session.persist(two);
            session.persist(three);

            Author author = session.get(Author.class, 3);
            session.remove(author);

            session.getTransaction().commit();
            session.close();
        }  catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}