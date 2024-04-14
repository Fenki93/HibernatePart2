package org.ddiachenko.service;

import org.ddiachenko.dao.ClientDaoImpl;
import org.ddiachenko.entity.Client;

public class ClientCrudService {

    private final ClientDaoImpl clientDao = new ClientDaoImpl();

    public boolean createClient(Client client){
       return clientDao.createClient(client);
    }

    public Client findClientById(Long id){
        return clientDao.getClientById(id);
    }

    public boolean updateClient(Client client){
      return clientDao.updateClient(client);
    }

    public void deleteClient(Long id){
        clientDao.deleteClientById(id);
    }
}
