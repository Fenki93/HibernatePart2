package org.ddiachenko.dao;

import org.ddiachenko.entity.Ticket;

import java.util.List;

public interface TicketDao {
    Ticket findById(Long id);

    List<Ticket> findByPlanetFrom(String name);

    List<Ticket> findByPlanetTo(String name);

    Ticket findByClientId(Long id);

    boolean save(Ticket ticket);

    boolean update(Ticket ticket);

    void delete(Ticket ticket);
}