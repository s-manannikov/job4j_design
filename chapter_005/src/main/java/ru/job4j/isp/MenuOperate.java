package ru.job4j.isp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class MenuOperate {

    public void operate(List<String> list) {
        Map<String, String> rsl = new HashMap<>();
        for (String i : list) {
            rsl.put(
                    i.replaceAll("(^-*\\s)(.*)(\\s.*)", "$2"),
                    i.replaceAll("(^-*\\s)(.*)(\\s.*)", "$2 $3")
            );
        }
        Scanner input = new Scanner(System.in);
        String select = input.nextLine();
        while (!select.equals(String.valueOf(0))) {
            System.out.println(rsl.getOrDefault(select, "not found!"));
            select = input.nextLine();
        }
    }
}