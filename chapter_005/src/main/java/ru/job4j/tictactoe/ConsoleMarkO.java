package ru.job4j.tictactoe;

import java.io.IOException;
import java.io.OutputStream;

public class ConsoleMarkO implements Mark<OutputStream> {
    protected final static char MARK_O = 'O';

    @Override
    public void print(OutputStream screen) {
        try {
            screen.write("O".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}