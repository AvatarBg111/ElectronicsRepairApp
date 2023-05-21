package org.elsys_bg.ElectronicsRepair.controller.resources;

import lombok.Data;
import org.elsys_bg.ElectronicsRepair.entity.Client;

@Data
public class ClientContactResource{
    private Integer id;
    private Client client;
    private String email;
    private String tel;
}