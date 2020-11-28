package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        try (FileInputStream in = new FileInputStream("even.txt")) {
            int i;
            while ((i = in.read()) != -1) {
                text.append((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        String[] lines = text.toString().split(System.lineSeparator());
        for (String line : lines) {
            if (Integer.parseInt(line) % 2 == 0) {
                System.out.println("Number " + line + " is even");
            } else {
                System.out.println("Number " + line + " is not even");
            }
        }
    }
}