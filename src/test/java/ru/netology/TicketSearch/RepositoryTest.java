package ru.netology.TicketSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RepositoryTest {
    Ticket ticket1 = new Ticket(1, 2000, "TYD", "CKH", 90);
    Ticket ticket2 = new Ticket(2, 2500, "DME", "LPK", 120);
    Ticket ticket3 = new Ticket(3, 4000, "SVO", "GDZ", 90);
    Ticket ticket4 = new Ticket(4, 3500, "PEZ", "LNX", 90);
    Ticket ticket5 = new Ticket(5, 3000, "KHV", "YKS", 90);

    @Test
    public void testAdd() {
        RepositoryTicket card = new RepositoryTicket();
        card.addTicket(ticket1);
        card.addTicket(ticket2);
        card.addTicket(ticket3);
        card.addTicket(ticket4);
        card.addTicket(ticket5);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = card.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void removeById() {
        RepositoryTicket card = new RepositoryTicket();
        card.addTicket(ticket1);
        card.addTicket(ticket2);
        card.addTicket(ticket3);
        card.addTicket(ticket4);
        card.addTicket(ticket5);
        card.removeById(2);
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};
        Ticket[] actual = card.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void findById() {
        RepositoryTicket card = new RepositoryTicket();
        card.addTicket(ticket1);
        card.addTicket(ticket2);
        card.addTicket(ticket3);
        card.addTicket(ticket4);
        card.addTicket(ticket5);
        Ticket[] expected = {ticket3};
        Ticket[] actual = new Ticket[] {card.findById(3)};
        Assertions.assertArrayEquals(expected, actual);
    }
}
