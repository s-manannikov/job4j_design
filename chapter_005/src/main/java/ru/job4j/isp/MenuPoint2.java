package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuPoint2 implements MainMenu, SubMenu {
    private final String name;
    private int subPoints = 0;
    private List<String> list = new ArrayList<>();

    public MenuPoint2(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public void addMainMenu() {
        list.add(2 + ". " + name);
    }

    @Override
    public void addSubMenu(int points) {
        for (int i = 1; i <= points; i++) {
            list.add("---- 2." + ++subPoints + ". " + name);
        }
    }
}
