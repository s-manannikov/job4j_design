package ru.job4j.tictactoe;

import java.io.IOException;
import java.io.OutputStream;

public class Field3x3 implements Field<OutputStream> {
    protected final static char[] FIELD = {'1', '-', '-', '-', '-', '-', '-', '-', '-', '-'};
    protected final static String[] WINNERS = {"1 2 3", "4 5 6", "7 8 9", "1 4 7", "2 5 8", "3 6 9", "1 5 9", "3 5 7"};

    @Override
    public OutputStream draw(OutputStream screen) {
        String row1 = " " + FIELD[1] + " " + FIELD[2] + " " + FIELD[3] + "    \u2190    1 2 3";
        String row2 = " " + FIELD[4] + " " + FIELD[5] + " " + FIELD[6] + "    \u2190    4 5 6";
        String row3 = " " + FIELD[7] + " " + FIELD[8] + " " + FIELD[9] + "    \u2190    7 8 9";
        try {
            screen.write(row1.getBytes());
            screen.write(System.lineSeparator().getBytes());
            screen.write(row2.getBytes());
            screen.write(System.lineSeparator().getBytes());
            screen.write(row3.getBytes());
            screen.write(System.lineSeparator().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return screen;
    }

    @Override
    public boolean checkWin(char mark) {
        boolean win = false;
        for (String s : WINNERS) {
            String[] winCombination = s.split(" ");
            if ((FIELD[Integer.parseInt(winCombination[0])] == mark)
                    && (FIELD[Integer.parseInt(winCombination[1])] == mark)
                    && (FIELD[Integer.parseInt(winCombination[2])] == mark)) {
                win = true;
                break;
            }
        }
        return win;
    }

    @Override
    public boolean checkFreeSpace(char[] array) {
        boolean free = false;
        for (char c : array) {
            if (c == '-') {
                free = true;
                break;
            }
        }
        return free;
    }

    @Override
    public boolean isNotOccupied(int i) {
        return FIELD[i] != 'X' && FIELD[i] != 'O';
    }
}