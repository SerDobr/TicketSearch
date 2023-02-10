package ru.netology.TicketSearch;

public class Ticket implements Comparable<Ticket> {
    protected int id; // ID
    protected int price; //цена
    protected String from; // Аэрапорт вылета
    protected String to; // Аэрапорт прилета


    protected int time; // время в пути

    public Ticket(int id, int price, String from, String to, int time) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.time = time;
    }

    public int getId() {
        return id;
    }


    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTime() {
        return time;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;

        }

    }


}