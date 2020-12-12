package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SearchBy {

    public List<Path> search(String type, String name, Path path) throws IOException {
        SearchFiles sf = new SearchFiles();
        if (type.equals("-f")) {
            sf = new SearchFiles(p -> p.getFileName().toString().equals(name));
        }
        if (type.equals("-m")) {
            String regex = name.replace("?", ".?").replace("*", ".*?");
            sf = new SearchFiles(p -> p.getFileName().toString().matches(regex));
        }
        Files.walkFileTree(path, sf);
        return sf.getList();
    }

    public void save(List<Path> list, String file) throws FileNotFoundException {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(file)))) {
            list.forEach(out::println);
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsSearchBy as = new ArgsSearchBy(args);
        SearchBy sb = new SearchBy();
        if (as.valid()) {
            List<Path> rsl = sb.search(as.searchType(), as.searchName(), Path.of(as.directory()));
            sb.save(rsl, as.output());
        }
    }
}