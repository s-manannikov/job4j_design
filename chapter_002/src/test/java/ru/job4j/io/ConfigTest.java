package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenMatchingPairs() {
        String path = "./files/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(
                config.value("hibernate.connection.driver_class"),
                is("org.postgresql.Driver")
        );
        assertThat(
                config.value("hibernate.connection.password"),
                is("password")
        );
        assertThat(
                config.value("hibernate.connection.username"),
                is("postgres")
        );
    }

    @Test (expected = UnsupportedOperationException.class)
    public void whenInvalidKey() {
        String path = "./files/app.properties";
        Config config = new Config(path);
        config.load();
        config.value("some key");
    }
}