package ru.netology.TicketSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ManagerTicketTest {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);
    Ticket ticket1 = new Ticket(1, 4000, "TYD", "CKH", 90);
    Ticket ticket2 = new Ticket(2, 2500, "DME", "LPK", 120);
    Ticket ticket3 = new Ticket(3, 4000, "SVO", "GDZ", 90);
    Ticket ticket4 = new Ticket(4, 3500, "PEZ", "LNX", 90);
    Ticket ticket5 = new Ticket(5, 3000, "TYD", "CKH", 90);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
    }

    @Test
    public void shouldAdd() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};
        Ticket[] actual = manager.findAllTicket();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromTo() {
        Ticket[] expected = {ticket3};
        Ticket[] actual = manager.searchByFromTo("SVO", "GDZ");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromTo2() {
        Ticket[] expected = {ticket1, ticket5};
        Ticket[] actual = manager.searchByFromTo("TYD", "CKH");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFrom() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromTo("SVO", "GDW");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTo() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromTo("SVO", "LPK");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNotId() {
        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(20);
        });
    }

    @Test
    public void shouldAddProductExistingId() {
        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            repo.addTicket(ticket1);
        });
    }

    @Test
    public void shouldSort() {
        Arrays.sort(manager.findAllTicket());

    }
}
