package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
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
    private List<String> answers = new ArrayList<>();
    private List<String> chatLog = new ArrayList<>();

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() throws IOException {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            answers = in.lines().collect(Collectors.toList());
        }
        String say = input.nextLine();
        chatLog.add(say);
        while (!say.equals(OUT)) {
            if (say.equals(STOP)) {
                while (!say.equals(CONTINUE)) {
                    say = input.nextLine();
                    chatLog.add(say);
                }
            }
            String answer = answers.get(random.nextInt(answers.size()));
            chatLog.add(answer);
            System.out.println(answer);
            say = input.nextLine();
            chatLog.add(say);
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String i : chatLog) {
                out.write(i + System.lineSeparator());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ConsoleChat cc = new ConsoleChat("chapter_002/files/console_chat.txt", "chapter_002/files/bot_answers.txt");
        cc.run();
    }
}