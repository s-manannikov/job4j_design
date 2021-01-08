package ru.job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import java.io.OutputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GameTest {

    @Ignore
    @Test
    public void whenMakeAllTurns() {
        String[] answers = {"1", "2", "3", "4", "5", "6", "7"};
        Output out = new StubOutput();
        Input in = new StubInput(answers);
        Player p1 = new Player1("player1");
        Player p2 = new Player2("player2");
        Field<OutputStream> field = new Field3x3();
        Game play = new Game(field, out, in);
        play.makeTurn(p1, p2);
        String[] rsl = out.toString().split(";");
        assertThat(rsl[15], is(
                " X O X    ←    1 2 3" + System.lineSeparator()
                        + " O X O    ←    4 5 6" + System.lineSeparator()
                        + " X - -    ←    7 8 9" + System.lineSeparator()));
        assertThat(rsl[14], is(System.lineSeparator() + p1.getName() + " wins!"));
        assertThat(rsl[10], is(p2.getName() + ", make your turn!"));
    }
}