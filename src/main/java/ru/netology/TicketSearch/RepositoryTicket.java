package ru.netology.TicketSearch;

public class RepositoryTicket {
    protected Ticket[] tics = new Ticket[0];

    protected void addTicket(Ticket tic) throws AlreadyExistsException {
if (findById(tic.getId())!=null){
throw new AlreadyExistsException("Товар с ID: " + tic.getId() + " уже существует!!!");
}
        Ticket[] tmp = new Ticket[tics.length + 1];
        for (int i = 0; i < tics.length; i++) {
            tmp[i] = tics[i];
        }
        tmp[tmp.length - 1] = tic;
        tics = tmp;
    }

    protected Ticket[] findAll() {
        return tics;
    }

    protected void removeById(int id) throws NotFoundException {
        if (findById(id) == null) {
            throw new NotFoundException("Товара с таким ID " + id + "не существует!");
        }
        Ticket[] tmp = new Ticket[tics.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tics) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tics = tmp;

    }

    protected Ticket findById(int id) {
        for (Ticket ticket : tics) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }
}
