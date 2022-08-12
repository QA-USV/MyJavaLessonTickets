package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketsRepositoryTest {

    TicketsRepository repo = new TicketsRepository();

    Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
    Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
    Ticket ticket3 = new Ticket(3, 3199, "Moscow", "Yekaterinburg", 125);
    Ticket ticket4 = new Ticket(4, 4199, "Moscow", "Yekaterinburg", 130);

    @Test
    void shouldFindAll() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindById() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);

        Ticket[] expected = {ticket2};
        Ticket actual = repo.findById(2);

        Assertions.assertArrayEquals(expected, new Ticket[]{actual});
    }

    @Test
    void shouldAddTickets() {
        repo.add(ticket1);
        repo.add(ticket2);

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldRemoveByArrivalPort() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.removeByArrivalPort("Kazan");


        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void removeByDeparturePort() {
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.removeByDeparturePort("Moscow");

        Ticket[] expected = {};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
