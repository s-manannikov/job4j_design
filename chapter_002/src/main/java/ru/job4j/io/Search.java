package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        Path start = Paths.get(args[0]);
        SearchFiles searchFiles = new SearchFiles(p -> p.toString().endsWith(args[1]));
        Files.walkFileTree(start, searchFiles);
        searchFiles.getList().forEach(System.out::println);
    }
}