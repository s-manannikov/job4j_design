package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

public class Player {
    private final String name;
    private final int number;
    private final boolean contract;
    private final Stats stats;
    private final String[] positions;

    public Player(String name, int number, boolean contract, Stats stats, String... positions) {
        this.name = name;
        this.number = number;
        this.contract = contract;
        this.stats = stats;
        this.positions = positions;
    }

    @Override
    public String toString() {
        return "Person{"
                + "name=" + name
                + ", number=" + number
                + ", contract=" + contract
                + ", stats=" + stats
                + ", positions=" + Arrays.toString(positions)
                + '}';
    }

    public static void main(String[] args) {
        final Player player = new Player("Name", 10, true, new Stats(50), "Midfielder", "Forward");
        final Gson gson = new GsonBuilder().create();
        String json = gson.toJson(player);
        System.out.println(json);
        final Player newPlayer = gson.fromJson(json, Player.class);
        System.out.println(newPlayer);
    }
}