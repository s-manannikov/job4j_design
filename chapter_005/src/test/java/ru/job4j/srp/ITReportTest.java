package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class ITReportTest {

    @Test
    public void itGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Name", now, now, 10000);
        store.add(worker);
        Report engine = new ITReport(store);
        StringBuilder expect = new StringBuilder();
        expect.append("<html>").append(System.lineSeparator())
                .append("<head>").append(System.lineSeparator())
                .append("<title>Report</title>").append(System.lineSeparator())
                .append("</head>").append(System.lineSeparator())
                .append("<body>").append(System.lineSeparator())
                .append("Name; Hired; Fired; Salary;").append("<br>")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append("<br>")
                .append(System.lineSeparator())
                .append("</body>").append(System.lineSeparator())
                .append("</html>");
        assertEquals(engine.generate(em -> true), expect.toString());
    }
}