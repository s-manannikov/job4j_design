package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String n = "name";
        int i = 10000000;
        double d = 1.1;
        char c = 'a';
        boolean b = true;
        long l = 10000000000000L;
        byte by = 100;
        short sh = 10000;
        LOG.trace("trace message");
        LOG.debug("info: n : {}, i : {}, d : {}, c : {}, b : {}, l : {}, by : {}, sh : {}", n, i, d, c, b, l, by, sh);
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}