package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.repository.ClientRepository;
import org.elsys_bg.ElectronicsRepair.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService{
    public final ClientRepository clientRepository;

    @Override
    public List<Client> findAll(){
        return clientRepository.findAll();
    }

    @Override
    public Client save(Client client){
        return clientRepository.save(client);
    }
}