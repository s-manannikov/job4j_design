package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class FindDuplicates {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get("/Users/test");
        Files.walkFileTree(start, new SearchDuplicates());
        SearchDuplicates.getList().forEach((key, value) -> System.out.println(key + " Duplicates: " + value));
    }

    public static class Data {
        String name;
        long size;

        public Data(String name, long size) {
            this.name = name;
            this.size = size;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Data data = (Data) o;
            return size == data.size
                    && Objects.equals(name, data.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, size);
        }

        @Override
        public String toString() {
            return "Data{"
                    + "name='" + name + '\''
                    + ", size=" + size
                    + '}';
        }
    }
}