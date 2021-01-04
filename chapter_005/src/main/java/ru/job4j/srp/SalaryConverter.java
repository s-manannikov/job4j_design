package ru.job4j.srp;

public class SalaryConverter implements Converter {
    private double rate;

    public SalaryConverter(double rate) {
        this.rate = rate;
    }

    @Override
    public double convert(double salary) {
        return salary / rate;
    }
}
