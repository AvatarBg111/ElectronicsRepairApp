package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.Client;

import java.util.List;

public interface ClientService{
    List<Client> findAll();

    Client save(Client client);

    void delete(Client client);

    void updateClient(Client client);
}