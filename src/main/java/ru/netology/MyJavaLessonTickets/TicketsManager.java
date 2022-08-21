package ru.netology.MyJavaLessonTickets;

import java.util.Arrays;

public abstract class TicketsManager implements Comparable<Ticket> {

    TicketsRepository repo;

//    private Ticket[] tickets = new Ticket[0];

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findAllTickets(String fromPort, String toPort) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if ((matches1(ticket, fromPort)) && (matches2(ticket, toPort))) {
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

    private boolean matches1(Ticket ticket, String search) {
        return ticket.getDeparturePort().contains(search);
    }

    private boolean matches2(Ticket ticket, String search) {
        return ticket.getArrivalPort().contains(search);
    }
}