package ru.job4j.io;

import java.io.FileOutputStream;

public class Multiple {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write("1*2=2".getBytes());
            out.write("1*3=3".getBytes());
            out.write("1*4=2".getBytes());
            out.write("1*5=2".getBytes());
            out.write("1*6=2".getBytes());
            out.write("1*7=2".getBytes());
            out.write("1*8=2".getBytes());
            out.write("1*9=2".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}