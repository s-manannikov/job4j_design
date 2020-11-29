package ru.job4j.io;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalyzeTest {

    @Test
    public void whenUnavailable() {
        String path1 = "./files/server_log_in.txt";
        String path2 = "./files/server_log_out.txt";
        Analyze analyze = new Analyze();
        analyze.unavailable(path1, path2);
        List<String> rsl = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(path2))) {
            rsl = in.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(rsl.get(0), is("10:58:01;10:59:01"));
        assertThat(rsl.get(1), is("11:01:02;11:02:02"));
        assertThat(rsl.get(2), is("11:03:03;11:05:03"));
    }
}