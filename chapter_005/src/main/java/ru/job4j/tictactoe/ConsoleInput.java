package ru.job4j.tictactoe;

import java.util.Scanner;

public class ConsoleInput implements Input {
    protected Scanner scanner = new Scanner(System.in);
    private final Output out;

    public ConsoleInput(Output out) {
        this.out = out;
    }

    @Override
    public String askStr(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = Integer.parseInt(askStr(question));
                invalid = false;
                if (value < 1 || value > 9) {
                    out.println("Please enter number from 1 to 9!");
                }
            } catch (Exception nfe) {
                out.println("Please enter number from 1 to 9!");
            }
        } while (invalid || value < 1 || value > 9);
        return value;
    }
}
