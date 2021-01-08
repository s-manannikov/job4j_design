package ru.job4j.tictactoe;

public class Player1 implements Player {
    private final String name;

    public Player1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public char move() {
        return ConsoleMarkX.MARK_X;
    }
}
