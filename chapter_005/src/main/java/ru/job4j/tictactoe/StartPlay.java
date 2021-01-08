package ru.job4j.tictactoe;

import java.io.OutputStream;

public class StartPlay {

    public static void main(String[] args) {
        Field<OutputStream> field = new Field3x3();
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput(output);
        Player p1 = new Player1("Donald Trump");
        Player p2 = new Player2("Joe Biden");
        Game play = new Game(field, output, input);
        play.makeTurn(p1, p2);
    }
}