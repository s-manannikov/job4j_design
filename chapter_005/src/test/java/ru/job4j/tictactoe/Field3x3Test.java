package ru.job4j.tictactoe;

import org.junit.Ignore;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class Field3x3Test {

    @Ignore
    @Test
    public void whenDrawTable() {
        Field<OutputStream> field = new Field3x3();
        assertThat(field.draw(new ByteArrayOutputStream()).toString(), is(
                " - - -    ←    1 2 3" + System.lineSeparator()
                        + " - - -    ←    4 5 6"  + System.lineSeparator()
                        + " - - -    ←    7 8 9"  + System.lineSeparator()));
    }

    @Test
    public void whenCheckWin() {
        Field<OutputStream> field = new Field3x3();
        assertFalse(field.checkWin('X'));
        Field3x3.FIELD[1] = 'X';
        Field3x3.FIELD[5] = 'X';
        Field3x3.FIELD[9] = 'X';
        assertTrue(field.checkWin('X'));
    }

    @Test
    public void whenCheckFreeSpace() {
        Field<OutputStream> field = new Field3x3();
        char[] expected = {'X', '-', 'O'};
        assertTrue(field.checkFreeSpace(expected));
        expected[1] = 'X';
        assertFalse(field.checkFreeSpace(expected));
    }

    @Test
    public void whenOccupiedOrNot() {
        Field<OutputStream> field = new Field3x3();
        Field3x3.FIELD[8] = 'X';
        assertTrue(field.isNotOccupied(7));
        assertFalse(field.isNotOccupied(8));
    }
}