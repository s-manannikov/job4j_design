package ru.job4j.serialization;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

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

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    public boolean isContract() {
        return contract;
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
        JSONObject jsonStats = new JSONObject("{\"points\":\"50\"}");
        List<String> list = new ArrayList<>();
        list.add("Midfielder");
        list.add("Forward");
        JSONArray jsonPositions = new JSONArray(list);
        final Player player = new Player("Name", 10, true, new Stats(50), "Midfielder", "Forward");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", player.getName());
        jsonObject.put("number", player.getNumber());
        jsonObject.put("contract", player.isContract());
        jsonObject.put("stats", jsonStats);
        jsonObject.put("positions", jsonPositions);
        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(player).toString());
    }
}