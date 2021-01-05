package ru.job4j.ocp;

import ru.job4j.srp.Employee;
import ru.job4j.srp.Report;
import ru.job4j.srp.Store;

import java.util.function.Predicate;

public class XMLReport implements Report {
    private Store store;

    public XMLReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("<employee>").append(System.lineSeparator())
                    .append("<name>").append(employee.getName()).append("</name>").append(System.lineSeparator())
                    .append("<hired>").append(employee.getHired()).append("</hired>").append(System.lineSeparator())
                    .append("<fired>").append(employee.getFired()).append("</fired>").append(System.lineSeparator())
                    .append("<salary>").append(employee.getSalary()).append("</salary>").append(System.lineSeparator())
                    .append("</employee>");

        }
        return text.toString();
    }
}