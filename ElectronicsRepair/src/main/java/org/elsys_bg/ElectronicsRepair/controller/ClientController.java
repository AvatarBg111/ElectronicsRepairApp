package org.elsys_bg.ElectronicsRepair.controller;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.service.ClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class ClientController{
    private final ClientService clientService;

    @GetMapping
    public String findAll(){
        return clientService.findAll().toString();
    }

    @GetMapping("/create")
    public String create(){
        Client client = new Client();
        client.setName("admin");
        client.setPassword("admin12345");

        return clientService.save(client).toString();
    }
}