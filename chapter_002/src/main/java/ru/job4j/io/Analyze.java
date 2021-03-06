package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Analyze {
    List<String> list = new ArrayList<>();

    public void unavailable(String source, String target) throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            String start = "", finish = "", prev = "000";
            String line = in.readLine();
            while (line != null) {
                if (check(line) && !check(prev)) {
                    start = line;
                    prev = line;
                }
                if (!check(line) && check(prev)) {
                    finish = line;
                }
                if (!start.isEmpty() && !finish.isEmpty()) {
                    list.add(start.substring(4, 12) + ";" + finish.substring(4, 12));
                    start = "";
                    finish = "";
                    prev = "000";
                }
                line = in.readLine();
            }
            list.forEach(i -> out.write(i + System.lineSeparator()));
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