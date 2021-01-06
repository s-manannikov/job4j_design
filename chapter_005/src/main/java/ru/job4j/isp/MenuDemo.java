package ru.job4j.isp;

public class MenuDemo {

    public static void main(String[] args) {
        MenuPoint1 m1 = new MenuPoint1("Task");
        m1.addMainMenu();
        m1.addSubMenu(3);
        m1.addSubSubMenu(3);
        m1.addSubMenu(2);
        m1.addSubSubMenu(1);
        m1.getList().forEach(System.out::println);
        System.out.println(System.lineSeparator() + "Choose menu option or press 0 for exit: ");
        new MenuOperate().operate(m1.getList());
    }
}
