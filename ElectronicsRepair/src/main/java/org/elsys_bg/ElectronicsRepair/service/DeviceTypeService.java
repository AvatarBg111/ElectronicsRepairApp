package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.DeviceType;

import java.util.List;

public interface DeviceTypeService{
    List<DeviceType> findAll();

    DeviceType save(DeviceType deviceType);
}