package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketsManagerTest {

    TicketsRepository repo = new TicketsRepository();

    TicketsManager manager = new TicketsManager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
    Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
    Ticket ticket3 = new Ticket(3, 3199, "Moscow", "Yekaterinburg", 125);
    Ticket ticket4 = new Ticket(4, 4199, "New York", "Yekaterinburg", 130);


    @Test
    public void add() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByDeparturePort() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findByDeparturePort("New York");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByFakeDeparturePort() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = manager.findByDeparturePort("London");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindByArrivalPort() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.findByArrivalPort("Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindByFakeArrivalPort() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);

        Ticket[] expected = {};
        Ticket[] actual = manager.findByArrivalPort("Vladivostok");

        Assertions.assertArrayEquals(expected, actual);
    }
}