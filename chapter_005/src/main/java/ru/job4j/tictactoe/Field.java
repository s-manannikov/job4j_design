package ru.job4j.tictactoe;

import java.io.OutputStream;

public interface Field<T> {

    OutputStream draw(T screen);

    boolean checkWin(char c);

    boolean checkFreeSpace(char[] array);

    boolean isNotOccupied(int i);
}
