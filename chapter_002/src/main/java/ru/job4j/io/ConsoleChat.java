package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {
    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8));
             BufferedWriter out = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            List<String> answers = in.lines().collect(Collectors.toList());
            Scanner input = new Scanner(System.in);
            String say = input.nextLine();
            out.write(say + System.lineSeparator());
            while (!say.equals(OUT)) {
                if (say.equals(STOP)) {
                    while (!say.equals(CONTINUE)) {
                        say = input.nextLine();
                        out.write(say + System.lineSeparator());
                    }
                }
                String answer = answers.get(new Random().nextInt(answers.size()));
                out.write(answer + System.lineSeparator());
                System.out.println(answer);
                say = input.nextLine();
                out.write(say + System.lineSeparator());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("chapter_002/files/console_chat.txt", "chapter_002/files/bot_answers.txt");
        cc.run();
    }
}