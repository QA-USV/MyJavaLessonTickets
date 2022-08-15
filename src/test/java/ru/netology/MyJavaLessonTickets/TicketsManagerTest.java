package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TicketsManagerTest {

    TicketsRepository repo = new TicketsRepository();

    TicketsManager manager = new TicketsManager(repo) {

        @Override
        public int compareTo(Ticket o) {
            return 0;
        }
    };

    Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
    Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
    Ticket ticket3 = new Ticket(3, 1999, "Moscow", "Chelyabinsk", 125);
    Ticket ticket4 = new Ticket(4, 1599, "New York", "Yekaterinburg", 130);

    Ticket ticket5 = new Ticket(5, 1599, "New York", "Yekaterinburg", 135);

    @BeforeEach
    public void addTickets() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldAddTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldSortByDeparturePort() {
//
//        Ticket[] expected = {ticket1, ticket3, ticket2};
//        Ticket[] actual = manager.findByDeparturePort("Moscow");
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldNotFindByFakeDeparturePort() {
//
//        Ticket[] expected = {};
//        Ticket[] actual = manager.findByDeparturePort("London");
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldSortByArrivalPort() {
//
//        Ticket[] expected = {ticket4, ticket5, ticket3};
//        Ticket[] actual = manager.findByArrivalPort("Yekaterinburg");
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void shouldNotFindByFakeArrivalPort() {
//
//        Ticket[] expected = {};
//        Ticket[] actual = manager.findByArrivalPort("Vladivostok");
//
//        Assertions.assertArrayEquals(expected, actual);
//    }

    @Test
    public void shouldFindAllTicketsFromAndTo() {

        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = manager.findAllTickets("Moscow", "Kazan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTicketsSame() {

        Ticket[] expected = {ticket4, ticket5};
        Ticket[] actual = manager.findAllTickets("New York", "Yekaterinburg");

        Assertions.assertArrayEquals(expected, actual);
    }



    @Test
    public void shouldFindAllTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}