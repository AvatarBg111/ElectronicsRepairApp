package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;
import org.elsys_bg.ElectronicsRepair.repository.SupportedDeviceForRepairRepository;
import org.elsys_bg.ElectronicsRepair.service.SupportedDeviceForRepairService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SupportedDeviceForRepairServiceImpl implements SupportedDeviceForRepairService{
    public final SupportedDeviceForRepairRepository supportedDeviceForRepairRepository;

    @Override
    public List<SupportedDeviceForRepair> findAll(){
        return supportedDeviceForRepairRepository.findAll();
    }

    @Override
    public SupportedDeviceForRepair save(SupportedDeviceForRepair supportedDeviceForRepair){
        return supportedDeviceForRepairRepository.save(supportedDeviceForRepair);
    }
}