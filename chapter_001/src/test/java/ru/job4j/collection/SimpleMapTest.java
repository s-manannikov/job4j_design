package ru.job4j.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {
    SimpleMap<String, String> test = new SimpleMap();
    Iterator it = test.iterator();

    @Before
    public void setUp() {
        test.insert("key1", "value1");
        test.insert("key2", "value2");
        test.insert("key3", "value3");
    }

    @Test
    public void whenInsertThenGet() {
        assertThat(test.get("key2"), is("value2"));
        assertThat(test.get("key3"), is("value3"));
        assertThat(test.get("key1"), is("value1"));
    }

    @Test
    public void whenInsertDuplicateKeyAndUpdateValue() {
        assertThat(test.insert("key2", "value22"), is(false));
        assertThat(test.get("key2"), is("value22"));
    }

    @Test
    public void whenDeleteThenIndexOf() {
        test.delete("key2");
        assertThat(test.indexOf("key2"), is(-1));
    }

    @Test
    public void whenIndexOf() {
        assertThat(test.indexOf("key1"), is(0));
        assertThat(test.indexOf("key2"), is(1));
        assertThat(test.indexOf("key3"), is(2));
    }

    @Test
    public void whenIterate() {
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("key1"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("key2"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("key3"));
        assertThat(it.hasNext(), is(false));
    }
}