package ru.job4j.collection;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> prev = previous.stream().collect(Collectors.toMap(i -> i.id, i -> i.name));
        Map<Integer, String> curr = current.stream().collect(Collectors.toMap(i -> i.id, i -> i.name));
        prev.keySet().retainAll(curr.keySet());
        info.deleted = previous.size() - prev.size();
        curr.keySet().retainAll(prev.keySet());
        info.added = current.size() - curr.size();
        info.changed = (int) curr.values().stream().filter(i -> !prev.containsValue(i)).count();
        return info;
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return id == user.id
                    && Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        @Override
        public String toString() {
            return "Info{"
                    + "added=" + added
                    + ", changed=" + changed
                    + ", deleted=" + deleted
                    + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Info info = (Info) o;
            return added == info.added
                    && changed == info.changed
                    && deleted == info.deleted;
        }

        @Override
        public int hashCode() {
            return Objects.hash(added, changed, deleted);
        }
    }
}