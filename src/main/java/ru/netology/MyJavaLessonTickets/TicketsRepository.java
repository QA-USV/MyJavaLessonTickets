package ru.netology.MyJavaLessonTickets;

public class TicketsRepository {

//    TicketsManager manager;
    private Ticket[] tickets = new Ticket[0];

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
        int i = 0;
        while (i < tickets.length) {
            tmp[i] = tickets[i];
            i++;
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public void removeByIdTicket(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Ticket with ID " + id + " not found."
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }

    public Ticket[] findAll() {
        return tickets;
    }
}