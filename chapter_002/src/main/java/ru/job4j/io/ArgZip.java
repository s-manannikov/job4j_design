package ru.job4j.io;

public class ArgZip {

    private final String[] args;

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if ((args.length < 3)
                || (!args[0].startsWith("-d="))
                || (!args[1].startsWith("-e="))
                || (!args[2].startsWith("-o="))) {
            throw new IllegalArgumentException();
        } else {
            return true;
        }
    }

    public String directory() {
        return args[0].substring(3);
    }

    public String exclude() {
        return args[1].substring(3);
    }

    public String output() {
        return args[2].substring(3);
    }
}