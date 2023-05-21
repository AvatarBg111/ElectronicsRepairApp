package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.ClientContact;

import java.util.List;

public interface ClientContactService{
    List<ClientContact> findAll();

    ClientContact save(ClientContact clientContact);
}