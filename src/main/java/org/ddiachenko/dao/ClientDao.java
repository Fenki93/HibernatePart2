package org.ddiachenko.dao;

import org.ddiachenko.entity.Client;

public interface ClientDao {

    boolean createClient(Client client);
    boolean updateClient(Client client);
    Client getClientById(Long clientId);
    void deleteClientById(Long clientId);
}