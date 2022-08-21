package ru.netology.MyJavaLessonTickets;

import java.util.Arrays;
import java.util.Objects;

public abstract class TicketsManager implements Comparable<Ticket> {

    TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findTicketsFromAndTo(String fromPort, String toPort) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if ((ticket.getDeparturePort().matches(fromPort)) && (ticket.getArrivalPort().matches(toPort))) {
                Ticket[] tmp = new Ticket[result.length + 1];
                int i = 0;
                while (i < result.length) {
                    tmp[i] = result[i];
                    i++;
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}