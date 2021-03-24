package ru.job4j.hsqldb;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrdersStoreTest {
    private BasicDataSource pool = new BasicDataSource();

    @Before
    public void setUp() throws SQLException {
        pool.setDriverClassName("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true");
        pool.setUsername("user");
        pool.setPassword("");
        pool.setMaxTotal(2);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./files/001.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @Test
    public void whenSaveOrderAndFindAllOneRowWithDescription() throws SQLException {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        List<Order> all = (List<Order>) store.findAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0).getDescription(), is("description1"));
        assertThat(all.get(0).getId(), is(1));
    }

    @Test
    public void whenSaveOrderAndFindById() throws SQLException {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        Order order = store.findById(1);
        assertThat(order.getDescription(), is("description1"));
    }

    @Test
    public void whenSaveOrderAndFindByName() throws SQLException {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        Order order = store.findByName("name1");
        assertThat(order.getId(), is(1));
    }

    @Test
    public void whenSaveOrderAndUpdate() throws SQLException {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        Order newOrder = Order.of("name2", "description2");
        store.updateOrder(newOrder, 1);
        Order order = store.findById(1);
        assertThat(order.getName(), is("name2"));
        assertThat(order.getDescription(), is("description2"));
    }

    @After
    public void drop() throws SQLException {
        pool.getConnection().prepareStatement("DROP TABLE orders").executeUpdate();
    }
}