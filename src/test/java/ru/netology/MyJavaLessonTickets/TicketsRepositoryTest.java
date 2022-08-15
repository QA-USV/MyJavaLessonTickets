package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TicketsRepositoryTest {

    TicketsRepository repo = new TicketsRepository();

    Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
    Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
    Ticket ticket3 = new Ticket(3, 3199, "Moscow", "Yekaterinburg", 125);
    Ticket ticket4 = new Ticket(4, 1599, "New York", "Yekaterinburg", 130);
    Ticket ticket5 = new Ticket(-1, 199, "Mordor", "Nowhere", 666);

    @BeforeEach
    public void addTickets() {

        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
    }

    @Test
    public void shouldNotAddTicketsWithSameId() {

        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(ticket2));
        Assertions.assertThrows(AlreadyExistsException.class, () -> repo.add(ticket4));
    }

    @Test
    public void shouldNotAddTicketsWithZeroAndNegativeId() {

        Assertions.assertThrows(UnacceptableException.class, () -> repo.add(ticket5));
    }
//    @BeforeEach
//    public void addTickets() {
//        repo.add(ticket1);
//        repo.add(ticket2);
//        repo.add(ticket3);
//        repo.add(ticket4);
//    }
//
    @Test
    public void shouldFindAll() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {

        Ticket[] expected = {ticket2};
        Ticket actual = repo.findById(2);

        Assertions.assertArrayEquals(expected, new Ticket[]{actual});
    }
//    @Test
//    public void shouldFindByArrivalPort() {
//        repo.add(ticket1);
//        repo.add(ticket2);
//        repo.add(ticket3);
//        repo.add(ticket4);
//
//        Ticket[] expected = {ticket3, ticket4};
//        Ticket[] actual = repo.findByArrivalPort("Yekaterinburg");
//        Assertions.assertArrayEquals(expected, actual);
//    }
    @Test
    public void shouldAddTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdTicket() {

        repo.removeByIdTicket(3);

        Ticket[] expected = {ticket1, ticket2, ticket4};
        Ticket[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotRemoveByFakeIdTicket() {

      Assertions.assertThrows(NotFoundException.class, () -> repo.removeByIdTicket(6));
    }
//    @Test
//    public void shouldRemoveByArrivalPort() {
//        repo.add(ticket1);
//        repo.add(ticket2);
//        repo.add(ticket3);
//        repo.add(ticket4);
//        repo.removeByArrivalPort("Kazan");
//
//        Ticket[] expected = {ticket3, ticket4};
//        Ticket[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
//
//    @Test
//    public void removeByDeparturePort() {
//        repo.add(ticket1);
//        repo.add(ticket2);
//        repo.add(ticket3);
//        repo.add(ticket4);
//        repo.removeByDeparturePort("Moscow");
//
//        Ticket[] expected = {ticket4};
//        Ticket[] actual = repo.findAll();
//
//        Assertions.assertArrayEquals(expected, actual);
//    }
}
