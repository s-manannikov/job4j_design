package ru.job4j.tictactoe;

import java.io.*;

public class Game {
    private final static String WIN_MESSAGE = " wins!";
    private final static String DRAW_MESSAGE = "Draw!";
    private static int count = 0;
    private final Field<OutputStream> field;
    private final Output output;
    private final Input input;

    public Game(Field<OutputStream> field, Output output, Input input) {
        this.field = field;
        this.output = output;
        this.input = input;
    }

    public void makeTurn(Player p1, Player p2) {
        Field<OutputStream> field = new Field3x3();
        while (field.checkFreeSpace(Field3x3.FIELD)) {
            output.println(choosePlayer(p1, p2) + ", make your turn!");
            output.println(field.draw(new ByteArrayOutputStream()));
            int n;
                do {
                    n = input.askInt("Enter number: ");
                } while (!field.isNotOccupied(n));
            Field3x3.FIELD[n] = chooseTurn(p1, p2);
            String result = getResult(p1, p2);
            if (!result.equals("next")) {
                output.println(result);
                break;
            }
        }
        output.println(field.draw(new ByteArrayOutputStream()));
    }

    private String getResult(Player p1, Player p2) {
        String rsl = "next";
        if (field.checkWin(ConsoleMarkX.MARK_X)) {
            rsl = System.lineSeparator() + p1.getName() + WIN_MESSAGE;
        }
        if (field.checkWin(ConsoleMarkO.MARK_O)) {
            rsl = System.lineSeparator() + p2.getName() + WIN_MESSAGE;
        }
        if (!field.checkFreeSpace(Field3x3.FIELD)) {
            rsl = DRAW_MESSAGE;
        }
        return rsl;
    }

    private char chooseTurn(Player p1, Player p2) {
        return (count % 2 != 0) ? p1.move() : p2.move();
    }

    private String choosePlayer(Player p1, Player p2) {
        return (++count % 2 != 0) ? p1.getName() : p2.getName();
    }
}