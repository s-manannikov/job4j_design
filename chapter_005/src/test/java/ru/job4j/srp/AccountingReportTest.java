package ru.job4j.srp;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class AccountingReportTest {

    @Test
    public void accountingGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Name", now, now, 10000);
        store.add(worker);
        Report engine = new AccountingReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary() / AccountingReport.EXCHANGE_RATE).append(";")
                .append(System.lineSeparator());
        assertEquals(engine.generate(em -> true), expect.toString());
    }
}