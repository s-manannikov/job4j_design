package ru.job4j.serialization;

public class Stats {
    private final int points;

    public Stats(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "Stats{"
                + "points='" + points + '\''
                + '}';
    }
}