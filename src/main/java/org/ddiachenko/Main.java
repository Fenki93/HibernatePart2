package org.ddiachenko;


import org.ddiachenko.entity.Client;
import org.ddiachenko.entity.Planet;
import org.ddiachenko.entity.Ticket;
import org.ddiachenko.service.ClientCrudService;
import org.ddiachenko.service.PlanetCrudService;
import org.ddiachenko.utils.DatabaseMigrationService;

import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) {

        DatabaseMigrationService.doMigrate();

        ClientCrudService clientCrudService = new ClientCrudService();
        PlanetCrudService planetCrudService = new PlanetCrudService();

        String newClientName = "Dmytro";
        Client client = new Client();
        client.setName(newClientName);

        Planet planetFrom = planetCrudService.findPlanetById("URN");
        Planet planetTo = planetCrudService.findPlanetById("VEN");

        Ticket ticket = new Ticket();
        ticket.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        ticket.setFromPlanet(planetFrom);
        ticket.setToPlanet(planetTo);
        ticket.setClient(client);
        client.getTickets().add(ticket);

        clientCrudService.createClient(client);
    }
}