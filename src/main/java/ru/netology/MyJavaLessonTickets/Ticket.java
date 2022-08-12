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

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparturePort() {
        return departurePort;
    }

    public void setDeparturePort(String departurePort) {
        this.departurePort = departurePort;
    }

    public String getArrivalPort() {
        return arrivalPort;
    }

    public void setArrivalPort(String arrivalPort) {
        this.arrivalPort = arrivalPort;
    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return 0;
    }
}