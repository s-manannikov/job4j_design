package ru.job4j.tictactoe;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkX implements Mark<OutputStream> {
    protected final static char MARK_X = 'X';

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("X".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}