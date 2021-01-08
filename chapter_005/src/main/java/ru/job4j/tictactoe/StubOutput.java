package ru.job4j.tictactoe;

public class StubOutput implements Output {
    private final StringBuilder buffer = new StringBuilder();

    @Override
    public void println(Object obj) {
        if (obj != null) {
            buffer.append(obj.toString());
        }
        buffer.append(";");
    }

    @Override
    public String toString() {
        return buffer.toString();
    }
}
