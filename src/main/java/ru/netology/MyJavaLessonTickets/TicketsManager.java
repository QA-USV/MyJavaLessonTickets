package ru.netology.MyJavaLessonTickets;

public class TicketsManager {

    TicketsRepository repo;

    private Ticket[] tickets = new Ticket[0];

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
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        return result;
    }

//    public Ticket[] removeByDeparturePort(String city) {
//        if (findByDeparturePort(city) == null) {
//            throw new NotFoundException(
//                    "Airport " + city + " not found."
//            );
//        } else {
//            Ticket[] tmp = new Ticket[0];
//            int index = 0;
//            for (Ticket ticket : tickets) {
//                if (ticket.getDeparturePort() != city) {
//                    tmp[index] = ticket;
//                    index++;
//                }
//                tickets = tmp;
//            }
//            return tmp;
//        }
//    }
        public boolean matches (Ticket ticket, String search){
            if (ticket.getDeparturePort().contains(search)) {
                return true;
            } else {
                return false;
            }
        }

        public Ticket[] findByArrivalPort (String city){
            Ticket[] result = new Ticket[0];
            for (Ticket ticket : repo.findAll()) {
                if (matches1(ticket, city)) {
                    Ticket[] tmp = new Ticket[result.length + 1];
                    for (int i = 0; i < result.length; i++) {
                        tmp[i] = result[i];
                    }
                    tmp[tmp.length - 1] = ticket;
                    result = tmp;
                }
            }
            return result;
        }

//        public Ticket[] removeByArrivalPort (String city){
//            if (findByArrivalPort(city) == null) {
//                throw new NotFoundException(
//                        "Airport " + city + " not found."
//                );
//            }
//            Ticket[] tmp = new Ticket[tickets.length];
//            int index = 0;
//            for (Ticket ticket : tickets) {
//                if (ticket.getArrivalPort() != city) {
//                    tmp[index] = ticket;
//                    index++;
//                }
//                tickets = tmp;
//            }
//            return tmp;
//        }

        public boolean matches1 (Ticket ticket, String search){
            if (ticket.getArrivalPort().contains(search)) {
                return true;
            } else {
                return false;
            }
        }
    }
