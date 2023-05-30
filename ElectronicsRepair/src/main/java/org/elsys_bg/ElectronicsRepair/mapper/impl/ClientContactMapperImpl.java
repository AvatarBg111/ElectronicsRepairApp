package org.elsys_bg.ElectronicsRepair.mapper.impl;

import org.elsys_bg.ElectronicsRepair.controller.resources.ClientContactResource;
import org.elsys_bg.ElectronicsRepair.controller.resources.ClientResource;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.entity.ClientContact;
import org.elsys_bg.ElectronicsRepair.mapper.ClientContactMapper;
import org.elsys_bg.ElectronicsRepair.service.impl.ClientContactServiceImpl;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ClientContactMapperImpl implements ClientContactMapper{
    @Override
    public ClientContact fromClientContactResource(ClientContactResource clientContactResource){
        if(clientContactResource == null){
            return null;
        }

        ClientContact clientContact = new ClientContact();
        clientContact.setId(clientContactResource.getId());
        clientContact.setClient(clientContactResource.getClient());
        clientContact.setEmail(clientContactResource.getEmail());
        clientContact.setTel(clientContactResource.getTel());

        return clientContact;
    }

    @Override
    public ClientContactResource toClientContactResource(ClientContact clientContact){
        if(clientContact == null){
            return null;
        }

        ClientContactResource clientContactResource = new ClientContactResource();
        clientContactResource.setId(clientContact.getId());
        clientContactResource.setClient(clientContact.getClient());
        clientContactResource.setEmail(clientContact.getEmail());
        clientContactResource.setTel(clientContact.getTel());

        return clientContactResource;
    }

    @Override
    public List<ClientContactResource> toClientContactResources(List<ClientContact> clientContacts){
        if(clientContacts == null){
            return Collections.emptyList();
        }

        List<ClientContactResource> clientContactResources = new ArrayList<>();
        for(ClientContact clientContact : clientContacts){
            clientContactResources.add(toClientContactResource(clientContact));
        }

        return clientContactResources;
    }
}