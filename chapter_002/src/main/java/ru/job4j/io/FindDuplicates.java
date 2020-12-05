package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class FindDuplicates {

    public static void main(String[] args) throws IOException {
        new FindDuplicates().search(Path.of("/Users/test")).forEach(System.out::println);
    }

    public List<FileProperty> search(Path path) throws IOException {
        SearchDuplicates sd = new SearchDuplicates();
        Files.walkFileTree(path, sd);
        return sd.getDuplicates();
    }
}