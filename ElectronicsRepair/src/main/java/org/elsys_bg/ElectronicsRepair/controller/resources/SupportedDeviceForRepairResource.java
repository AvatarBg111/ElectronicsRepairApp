package org.elsys_bg.ElectronicsRepair.controller.resources;

import lombok.Data;
import org.elsys_bg.ElectronicsRepair.entity.DeviceType;

@Data
public class SupportedDeviceForRepairResource{
    private Integer id;
    private DeviceType deviceType;
    private String manufacturer;
}