package ru.job4j.srp;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private Store store;
    public static final int EXCHANGE_RATE = 90;

    public AccountingReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;");
        for (Employee employee : store.findBy(filter)) {
            text.append(System.lineSeparator())
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary() / EXCHANGE_RATE).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

