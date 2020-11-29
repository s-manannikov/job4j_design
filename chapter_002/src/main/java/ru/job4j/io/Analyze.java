package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Analyze {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            list = read.lines().collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String start = "", finish = "", prev = "000";
            for (String i : list) {
                if (check(i) && !check(prev)) {
                    start = i;
                    prev = i;
                }
                if (!check(i) && check(prev)) {
                    finish = i;
                }
                if (!start.isEmpty() && !finish.isEmpty()) {
                    out.write(start.substring(4, 12) + ";" + finish.substring(4, 12) + System.lineSeparator());
                    start = "";
                    finish = "";
                    prev = "000";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean check(String s) {
        return Integer.parseInt(s.substring(0, 3)) >= 400;
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("./files/unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}