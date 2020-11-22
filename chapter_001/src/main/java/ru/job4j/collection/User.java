package ru.job4j.collection;

import java.util.*;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }

    public static void main(String[] args) {
        User user1 = new User("Name", 2, new GregorianCalendar(1900, 0, 1));
        User user2 = new User("Name", 2, new GregorianCalendar(1900, 0, 1));
        Map<User, Object> map = new HashMap<>();
        map.put(user1, user1);
        map.put(user2, user2);
        for (User key : map.keySet()) {
            System.out.println(key);
        }
    }
}