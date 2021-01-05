package ru.job4j.ocp;

import ru.job4j.srp.Employee;
import ru.job4j.srp.Report;
import ru.job4j.srp.Store;

import java.util.function.Predicate;

public class JSONReport implements Report {
    private Store store;

    public JSONReport(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            text.append("{ \"Name\":\"").append(employee.getName())
                    .append("\", \"Hired\":").append(employee.getHired())
                    .append(", \"Fired\":").append(employee.getFired())
                    .append(", \"Salary\":").append(employee.getSalary()).
                    append(" }");
        }
        return text.toString();
    }
}
