package ru.job4j.tictactoe;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.io.ByteArrayOutputStream;

public class ConsoleMarkOTest {

    @Test
    public void print() {
        var out = new ByteArrayOutputStream();
        new ConsoleMarkO().print(out);
        assertThat(out.toString(), is("O"));
    }
}