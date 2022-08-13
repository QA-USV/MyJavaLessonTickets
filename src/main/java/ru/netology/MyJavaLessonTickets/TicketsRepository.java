package ru.netology.MyJavaLessonTickets;

public class TicketsRepository {

    TicketsManager manager;
    private Ticket[] tickets = new Ticket[0];


    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

//    public Ticket[] findByArrivalPort(String city) {
//        Ticket[] result = new Ticket[0];
//        for (Ticket ticket : findAll()) {
//            if (ticket.getArrivalPort().equals(city)){
//                Ticket[] tmp = new Ticket[result.length + 1];
//                for (int i = 0; i < result.length; i++) {
//                    tmp[i] = result[i];
//                }
//                tmp[tmp.length - 1] = ticket;
//                result = tmp;
//            }
//        }
//        return result;
//    }
//
//    public boolean matches2 (Ticket ticket, String search){
//        if (ticket.getArrivalPort().contains(search)) {
//            return true;
//        } else {
//            return false;
//        }
//    }

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

    public void removeByArrivalPort(String city) {
        if (manager.findByArrivalPort(city) == null) {
            throw new NotFoundException(
                    "Airport " + city + " not found."
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getArrivalPort() != city) {
                tmp[index] = ticket;
                index++;
            }
            tickets = tmp;
        }
    }

    public void removeByDeparturePort(String city) {
        if (manager.findByDeparturePort(city) == null) {
            throw new NotFoundException(
                    "Airport " + city + " not found."
            );
        }
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getDeparturePort() != city) {
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