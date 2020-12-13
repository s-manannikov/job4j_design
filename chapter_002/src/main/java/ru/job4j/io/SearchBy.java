package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Predicate;

public class SearchBy {

    public List<Path> search(Path path, Predicate<Path> predicate) throws IOException {
        SearchFiles sf = new SearchFiles(predicate);
        Files.walkFileTree(path, sf);
        return sf.getList();
    }

    public Predicate<Path> condition(ArgsSearchBy args) {
        Predicate<Path> predicate = p -> true;
        String type = args.searchType();
        String name = args.searchName();
        if (type.equals("-f")) {
            predicate = (p -> p.getFileName().toString().equals(name));
        }
        if (type.equals("-m")) {
            String s = pattern(name);
            predicate = p -> p.getFileName().toString().matches(s);
        }
        if (type.equals("-r")) {
            predicate = p -> p.getFileName().toString().matches(name);
        }
        return predicate;
    }

    private String pattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            switch (c) {
                case '?' -> sb.append(".?");
                case '*' -> sb.append(".*?");
                case '.' -> sb.append("\\.");
                default -> sb.append(c);
            }
        }
        return sb.toString();
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
            Predicate<Path> predicate = sb.condition(as);
            List<Path> rsl = sb.search(Path.of(as.directory()), predicate);
            sb.save(rsl, as.output());
        }
    }
}