package ru.netology.MyJavaLessonTickets;

public class Ticket implements Comparable<Ticket> {

    protected int id;
    protected int price;
    protected String departurePort;
    protected String arrivalPort;
    protected int flightTime;

    public Ticket(int id, int price, String departurePort, String arrivalPort, int flightTime) {
        this.id = id;
        this.price = price;
        this.departurePort = departurePort;
        this.arrivalPort = arrivalPort;
        this.flightTime = flightTime;
    }

    public int getId() {
        return id;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    @Override
    public int compareTo(Ticket o) {
        return Integer.compare(this.price, o.price);
    }
}