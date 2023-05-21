package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.DeviceType;
import org.elsys_bg.ElectronicsRepair.repository.DeviceTypeRepository;
import org.elsys_bg.ElectronicsRepair.service.DeviceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeviceTypeServiceImpl implements DeviceTypeService{
    public final DeviceTypeRepository deviceTypeRepository;

    @Override
    public List<DeviceType> findAll(){
        return deviceTypeRepository.findAll();
    }

    @Override
    public DeviceType save(DeviceType deviceType){
        return deviceTypeRepository.save(deviceType);
    }
}