package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void temporaryFolder() throws IOException {
        Analyze analyze = new Analyze();
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01");
            out.println("200 10:57:01");
            out.println("400 10:58:01");
            out.println("200 10:59:02");
            out.println("500 11:01:02");
            out.println("200 11:02:02");
        }
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            assertThat(in.readLine(), is("10:58:01;10:59:02"));
            assertThat(in.readLine(), is("11:01:02;11:02:02"));
        }
    }

    @Test
    public void whenUnavailable() throws IOException {
        String path1 = "./files/server_log_in.txt";
        String path2 = "./files/server_log_out.txt";
        Analyze analyze = new Analyze();
        analyze.unavailable(path1, path2);
        try (BufferedReader in = new BufferedReader(new FileReader(path2))) {
            List<String> rsl = in.lines().collect(Collectors.toList());
            assertThat(rsl.get(0), is("10:58:01;10:59:01"));
            assertThat(rsl.get(1), is("11:01:02;11:02:02"));
            assertThat(rsl.get(2), is("11:03:03;11:05:03"));
        }
    }
}