package org.elsys_bg.ElectronicsRepair.controller.resources;

import lombok.Data;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.entity.OrderStatus;
import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;

@Data
public class OrderResource{
    private Integer id;
    private Client client;
    private SupportedDeviceForRepair supportedDeviceType;
    private String model;
    private String description;
    private OrderStatus orderStatus;
}