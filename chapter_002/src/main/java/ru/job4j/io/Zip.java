package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            for (Path i : sources) {
            zip.putNextEntry(new ZipEntry(i.toFile().getAbsolutePath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(i.toFile()))) {
                zip.write(out.readAllBytes());
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void packSingleFile(Path source, Path target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target.toFile())))) {
            zip.putNextEntry(new ZipEntry(source.toFile().getAbsolutePath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source.toFile()))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Path> search(String exclude, Path source) throws IOException {
        SearchFiles searchFiles = new SearchFiles(p -> !p.toString().endsWith(exclude));
        Files.walkFileTree(source, searchFiles);
        return searchFiles.getList();
    }

    public static void main(String[] args) throws IOException {
        ArgZip argZip = new ArgZip(args);
        if (argZip.valid()) {
            new Zip().packFiles(
                    new Zip().search(argZip.exclude(), Path.of(argZip.directory())),
                    Path.of(argZip.output())
            );
        }
        new Zip().packSingleFile(
                Path.of("./chapter_002/pom.xml"),
                Path.of("./chapter_002/pom.zip")
        );
    }
}