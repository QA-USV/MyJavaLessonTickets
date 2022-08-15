package ru.netology.MyJavaLessonTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TicketTest implements Comparable<Ticket> {

    TicketsRepository repo = new TicketsRepository();

    @Test
    void compareTo() {
        Ticket ticket1 = new Ticket(1, 1299, "Moscow", "Kazan", 105);
        Ticket ticket2 = new Ticket(2, 2199, "Moscow", "Kazan", 105);
        Ticket ticket3 = new Ticket(3, 1999, "Moscow", "Yekaterinburg", 125);
        Ticket ticket4 = new Ticket(4, 1599, "New York", "Yekaterinburg", 130);

        Ticket ticket5 = new Ticket(5, 1599, "Washington", "Yekaterinburg", 130);

        Arrays.sort(repo.findAll());
    }

    @Override
    public int compareTo(Ticket o) {
        return 0;
    }
}