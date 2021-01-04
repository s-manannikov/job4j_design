package ru.job4j.srp;

import java.util.function.Predicate;

public class AccountingReport implements Report {
    private Store store;
    private Converter converter;

    public AccountingReport(Store store, double rate) {
        this.store = store;
        converter = new SalaryConverter(rate);
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
                    .append(converter.convert(employee.getSalary())).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

