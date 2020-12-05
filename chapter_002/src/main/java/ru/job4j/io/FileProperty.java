package ru.job4j.io;

import java.util.Objects;

public class FileProperty {
    private String name;
    private long size;

    public FileProperty(String name, long size) {
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
        FileProperty that = (FileProperty) o;
        return size == that.size
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "FileProperty{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }
}
