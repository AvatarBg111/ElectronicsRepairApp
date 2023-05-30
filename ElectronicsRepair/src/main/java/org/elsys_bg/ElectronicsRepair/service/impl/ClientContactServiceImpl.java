package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.controller.resources.ClientContactResource;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.entity.ClientContact;
import org.elsys_bg.ElectronicsRepair.mapper.ClientContactMapper;
import org.elsys_bg.ElectronicsRepair.repository.ClientContactRepository;
import org.elsys_bg.ElectronicsRepair.service.ClientContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClientContactServiceImpl implements ClientContactService{
    private final ClientContactRepository clientContactRepository;
    private final ClientContactMapper clientContactMapper;

    public ClientContact getById(Long clientContactId){
        return clientContactRepository.getById(clientContactId);
    }

    @Override
    public List<ClientContact> findAll(){
        return clientContactRepository.findAll();
    }

    @Override
    public ClientContact save(ClientContact clientContact){
        return clientContactRepository.save(clientContact);
    }

    @Override
    public void delete(ClientContact contact){
        clientContactRepository.delete(contact);
    }

    @Override
    public void updateClientContact(ClientContact contact) throws NoSuchElementException {
        ClientContact existingContact = clientContactRepository.findById(Long.valueOf(contact.getId())).orElse(null);
        if(existingContact != null){
            existingContact.setTel(contact.getTel());
            existingContact.setEmail(contact.getEmail());
            existingContact.setClient(contact.getClient());
            clientContactRepository.save(existingContact);
        }else{
            throw new NoSuchElementException("ERR: Client contact with ID " + contact.getId() + " does not exist.");
        }
    }

    public void deleteClientContactByClient(Client client){
        clientContactRepository.deleteByClient(client);
    }

    public ClientContact addContact(Client client, String email, String tel){
        ClientContactResource newClientContact = new ClientContactResource();
        newClientContact.setClient(client);
        newClientContact.setEmail(email);
        newClientContact.setTel(tel);
        return clientContactRepository.save(clientContactMapper.fromClientContactResource(newClientContact));
    }
}