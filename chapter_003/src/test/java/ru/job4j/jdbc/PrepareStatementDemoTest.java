package ru.job4j.jdbc;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class PrepareStatementDemoTest {
    City city1 = new City(1, "City_Name1", 100000);
    City city2 = new City(2, "City_Name2", 200000);

    @Test
    public void whenInsert() throws Exception {
        PrepareStatementDemo ps = new PrepareStatementDemo();
        ps.insert(city1);
        ps.insert(city2);
        List<City> rsl = ps.findAll();
        assertThat(rsl.get(0).getName(), is("City_Name1"));
        assertThat(rsl.get(1).getName(), is("City_Name2"));
        assertThat(rsl.get(0).getPopulation(), is(100000));
        assertThat(rsl.get(1).getPopulation(), is(200000));
        ps.delete(rsl.get(0).getId());
        ps.delete(rsl.get(1).getId());
    }

    @Test
    public void whenUpdate() throws Exception {
        PrepareStatementDemo ps = new PrepareStatementDemo();
        ps.insert(city1);
        city2.setId(city1.getId());
        ps.update(city2);
        List<City> rsl = ps.findAll();
        assertThat(rsl.get(0).getName(), is("City_Name2"));
        assertThat(rsl.get(0).getPopulation(), is(200000));
        assertThat(rsl.get(0).getId(), is(city1.getId()));
        ps.delete(rsl.get(0).getId());
    }

    @Test
    public void whenDelete() throws Exception {
        PrepareStatementDemo ps = new PrepareStatementDemo();
        ps.insert(city1);
        ps.delete(city1.getId());
        List<City> rsl = ps.findAll();
        assertThat(rsl.isEmpty(), is(true));
    }
}