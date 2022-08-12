package ru.netology.MyJavaLessonTickets;

public class TicketsManager {

    TicketsRepository repo;

    public TicketsManager(TicketsRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.add(ticket);
    }

    public Ticket[] findByDeparturePort(String city) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, city)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                    result = tmp;
                }
            }
        }
        return result;
    }

    public boolean matches(Ticket ticket, String search) {
        if (ticket.getDeparturePort().contains(search)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findByArrivalPort(String city) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches1(ticket, city)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                    result = tmp;
                }
            }
        }
        return result;
    }

    public boolean matches1(Ticket ticket, String search) {
        if (ticket.getArrivalPort().contains(search)) {
            return true;
        } else {
            return false;
        }
    }
}
