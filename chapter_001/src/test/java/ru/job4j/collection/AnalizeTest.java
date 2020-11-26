package ru.job4j.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    Analize test = new Analize();
    List<Analize.User> prev = new ArrayList<>();
    List<Analize.User> curr = new ArrayList<>();
    Analize.User user1 = new Analize.User(1, "name1");
    Analize.User user2 = new Analize.User(2, "name2");
    Analize.User user3 = new Analize.User(3, "name3");
    Analize.User user4 = new Analize.User(4, "name4");
    Analize.User user5 = new Analize.User(5, "name4");
    Analize.User user6 = new Analize.User(2, "name22");

    @Test
    public void whenAdded() {
        prev = List.of(user1);
        curr = List.of(user1, user2, user3, user4, user5);
        Analize.Info out = test.diff(prev, curr);
        Analize.Info expected = new Analize.Info(4, 0, 0);
        assertThat(out, is(expected));
    }

    @Test
    public void whenChanged() {
        prev = List.of(user2);
        curr = List.of(user6);
        Analize.Info out = test.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 1, 0);
        assertThat(out, is(expected));
    }

    @Test
    public void whenDeleted() {
        prev = List.of(user1, user2, user3, user4);
        curr = List.of(user1);
        Analize.Info out = test.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 0, 3);
        assertThat(out, is(expected));
    }

    @Test
    public void whenDiff() {
        prev = List.of(user1, user2, user3, user4);
        curr = List.of(user1, user4, user5, user6);
        Analize.Info out = test.diff(prev, curr);
        Analize.Info expected = new Analize.Info(1, 1, 1);
        assertThat(out, is(expected));
    }

    @Test
    public void whenNoDiff() {
        prev = List.of(user1, user2, user3, user4, user5);
        curr = List.of(user1, user2, user3, user4, user5);
        Analize.Info out = test.diff(prev, curr);
        Analize.Info expected = new Analize.Info(0, 0, 0);
        assertThat(out, is(expected));
    }
}