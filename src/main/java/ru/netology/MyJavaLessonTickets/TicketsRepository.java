package ru.netology.MyJavaLessonTickets;

public class TicketsRepository {

    private Ticket[] tickets = new Ticket[0];


    public Ticket[] findAll() {
        return tickets;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        if (findById(ticket.id) != null) {
            throw new AlreadyExistsException(
                    "Ticket with id: " + ticket.getId() + " already exist."
            );
        }
        if (ticket.id <= 0) {
            throw new UnacceptableException(
                    "Ticket id must be more then zero."
            );
        }
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findByArrivalPort(String text) {
        for (Ticket ticket : tickets) {
            if (ticket.getArrivalPort() == text) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByArrivalPort(String text) {
        if (findByArrivalPort(text) == null) {
            throw new NotFoundException(
                    "Airport " + text + " not found."
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getArrivalPort() != text) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }

    public Ticket findByDeparturePort(String text) {
        for (Ticket ticket : tickets) {
            if (ticket.getDeparturePort() == text) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByDeparturePort(String text) {
        if (findByDeparturePort(text) == null) {
            throw new NotFoundException(
                    "Airport " + text + " not found."
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getDeparturePort() != text) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }
}