package ru.job4j.tdd;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

public class CinemaTest {
    Account account = new AccountCinema();
    Cinema cinema = new Cinema3D();

    @Ignore
    @Test
    public void whenBuyTicket() {
        Calendar date = Calendar.getInstance();
        date.set(2020, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertEquals(ticket, new Ticket3D());
    }

    @Ignore
    @Test
    public void whenFindSession() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertEquals(sessions, List.of(new Session3D()));
    }

    @Ignore
    @Test
    public void whenNoTicket() {
        Calendar date = Calendar.getInstance();
        date.set(2030, Calendar.NOVEMBER, 10, 23, 0);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertNull(ticket);
    }

    @Ignore
    @Test
    public void whenNoSession() {
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertEquals(sessions.size(), 0);
    }
}