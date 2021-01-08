package ru.job4j.tictactoe;

public class Player2 implements Player {
    private final String name;

    public Player2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public char move() {
        return ConsoleMarkO.MARK_O;
    }
}
