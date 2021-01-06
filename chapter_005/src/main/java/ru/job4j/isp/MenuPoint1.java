package ru.job4j.isp;

import java.util.ArrayList;
import java.util.List;

public class MenuPoint1 implements MainMenu, SubMenu, SubSubMenu {
    private final String name;
    private int subPoints = 0;
    private List<String> list = new ArrayList<>();

    public MenuPoint1(String name) {
        this.name = name;
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public void addMainMenu() {
        list.add(1 + ". " + name);
    }

    @Override
    public void addSubMenu(int points) {
        for (int i = 1; i <= points; i++) {
            list.add("---- 1." + ++subPoints + ". " + name);
        }
    }

    @Override
    public void addSubSubMenu(int points) {
        int subSubPoints = 1;
        for (int i = 1; i <= points; i++) {
            list.add("-------- 1." + subPoints + "."  + subSubPoints++ + ". " + name);
        }
    }
}