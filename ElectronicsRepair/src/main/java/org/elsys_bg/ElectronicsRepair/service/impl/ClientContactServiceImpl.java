package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.ClientContact;
import org.elsys_bg.ElectronicsRepair.repository.ClientContactRepository;
import org.elsys_bg.ElectronicsRepair.service.ClientContactService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientContactServiceImpl implements ClientContactService{
    private final ClientContactRepository clientContactResource;

    @Override
    public List<ClientContact> findAll(){
        return clientContactResource.findAll();
    }

    @Override
    public ClientContact save(ClientContact clientContact){
        return clientContactResource.save(clientContact);
    }
}