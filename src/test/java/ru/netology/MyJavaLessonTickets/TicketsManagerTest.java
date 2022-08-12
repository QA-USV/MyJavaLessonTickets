package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Test;

public class TicketsManagerTest {

    TicketsRepository repo = new TicketsRepository();

    TicketsManager manager = new TicketsManager(repo);

    Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
    Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
    Ticket ticket3 = new Ticket(3, 3199, "Moscow", "Yekaterinburg", 125);
    Ticket ticket4 = new Ticket(4, 4199, "Moscow", "Yekaterinburg", 130);


    @Test
    void add() {


    }

    @Test
    void findByDeparturePort() {
    }

    @Test
    void matches() {
    }

    @Test
    void findByArrivalPort() {
    }

    @Test
    void matches1() {
    }
}
