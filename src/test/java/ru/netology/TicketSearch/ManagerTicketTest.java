package ru.netology.TicketSearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ManagerTicketTest {
    RepositoryTicket repo = new RepositoryTicket();
    ManagerTicket manager = new ManagerTicket(repo);
    Ticket ticket1 = new Ticket(1, 4000, "SVO", "GDZ", 140);
    Ticket ticket2 = new Ticket(2, 2500, "DME", "LPK", 120);
    Ticket ticket3 = new Ticket(3, 3000, "SVO", "GDZ", 100);
    Ticket ticket4 = new Ticket(4, 3500, "PEZ", "LNX", 110);
    Ticket ticket5 = new Ticket(5, 3200, "SVO", "GDZ", 80);
    Ticket ticket6 = new Ticket(6, 4000, "TYD", "CKH", 90);
    Ticket ticket7 = new Ticket(7, 2600, "DME", "LPK", 120);
    Ticket ticket8 = new Ticket(8, 2400, "SVO", "GDZ", 160);
    Ticket ticket9 = new Ticket(9, 3300, "PEZ", "LNX", 90);
    Ticket ticket10 = new Ticket(10, 3100, "SVO", "GDZ", 130);
    Comparator<Ticket> comparator = new TimeComporator();
    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        comparator = new TimeComporator();


    }

    @Test
    public void shouldAdd() {
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5,ticket6, ticket7, ticket8, ticket9, ticket10};
        Ticket[] actual = manager.findAllTicket();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromTo() {
        Ticket[] expected = {ticket9,ticket4};
        Ticket[] actual = manager.searchByFromTo("PEZ", "LNX",comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFromTo2() {
        Ticket[] expected = {ticket5, ticket3,ticket10,ticket1,ticket8};
        Ticket[] actual = manager.searchByFromTo("SVO", "GDZ",comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchFrom() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromTo("SVO", "GDW",comparator);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchTo() {
        Ticket[] expected = {};
        Ticket[] actual = manager.searchByFromTo("SVO", "LPK",comparator);
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
    public void shouldSortAdd() {
        Ticket[] expected = {ticket8, ticket2, ticket7, ticket3, ticket10,ticket5, ticket9, ticket4, ticket1, ticket6};
        Ticket[] actual =(manager.findAllTicket());
        Arrays.sort(manager.findAllTicket());
        Assertions.assertArrayEquals(expected, actual);
    }
}
