package ru.job4j.io;

public class ArgsSearchBy {
    private final String[] args;

    public ArgsSearchBy(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length < 7) {
            throw new IllegalArgumentException();
        }
        if ((!args[0].equals("-d")) || (!args[2].equals("-n")) || (!args[5].equals("-o"))) {
            throw new IllegalArgumentException();
        }
        if ((!args[4].equals("-m")) && (!args[4].equals("-f")) && (!args[4].equals("-r"))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    public String directory() {
        return args[1];
    }

    public String searchName() {
        return args[3];
    }

    public String searchType() {
        return args[4];
    }

    public String output() {
        return args[6];
    }
}