package ru.netology.TicketSearch;

import ru.netology.TicketSearch.RepositoryTicket;
import ru.netology.TicketSearch.Ticket;

import static java.util.regex.Pattern.matches;

public class ManagerTicket {
    public RepositoryTicket repo;

    public ManagerTicket(RepositoryTicket repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.addTicket(ticket);

    }

    public Ticket[] findAllTicket() {
        Ticket[] all = repo.findAll();
        return all;
    }

    public Ticket[] searchByFromTo(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll())
            if (matches(ticket, from, to)) {
                int res = result.length + 1;
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;

            }
        return result;

    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
            return true;

        } else {
            return false;
        }
    }
}
