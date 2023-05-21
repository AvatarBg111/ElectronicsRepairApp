package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;

import java.util.List;

public interface SupportedDeviceForRepairService{
    List<SupportedDeviceForRepair> findAll();

    SupportedDeviceForRepair save(SupportedDeviceForRepair supportedDeviceForRepair);
}