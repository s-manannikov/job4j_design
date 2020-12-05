package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class SearchDuplicates implements FileVisitor<Path> {
    private Set<FileProperty> met = new HashSet<>();
    private List<FileProperty> duplicates = new ArrayList<>();

    public Set<FileProperty> getMet() {
        return met;
    }

    public List<FileProperty> getDuplicates() {
        return duplicates;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.getFileName().toString(), attrs.size());
        if (!met.contains(fileProperty)) {
            met.add(fileProperty);
        } else {
            duplicates.add(fileProperty);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }
}