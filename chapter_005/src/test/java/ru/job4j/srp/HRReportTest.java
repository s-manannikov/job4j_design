package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class HRReportTest {

    @Test
    public void hrGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker1 = new Employee("Name1", now, now, 10000);
        Employee worker2 = new Employee("Name2", now, now, 13000);
        Employee worker3 = new Employee("Name3", now, now, 11000);
        store.add(worker1);
        store.add(worker2);
        store.add(worker3);
        Report engine = new HRReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator())
                .append(worker1.getName()).append(";")
                .append(worker1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertEquals(engine.generate(em -> true), expect.toString());
    }
}