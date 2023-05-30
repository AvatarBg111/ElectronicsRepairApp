package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.controller.resources.DeviceTypeResource;
import org.elsys_bg.ElectronicsRepair.entity.DeviceType;
import org.elsys_bg.ElectronicsRepair.mapper.DeviceTypeMapper;
import org.elsys_bg.ElectronicsRepair.repository.DeviceTypeRepository;
import org.elsys_bg.ElectronicsRepair.service.DeviceTypeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DeviceTypeServiceImpl implements DeviceTypeService{
    public final DeviceTypeRepository deviceTypeRepository;
    public final DeviceTypeMapper deviceTypeMapper;

    public DeviceType getById(Long deviceTypeId){
        return deviceTypeRepository.getById(deviceTypeId);
    }

    public DeviceType getByDevice(String deviceType){
        return deviceTypeRepository.getByDevice(deviceType);
    }

    @Override
    public List<DeviceType> findAll(){
        return deviceTypeRepository.findAll();
    }

    @Override
    public DeviceType save(DeviceType deviceType){
        return deviceTypeRepository.save(deviceType);
    }

    @Override
    public void delete(DeviceType deviceType){
        deviceTypeRepository.delete(deviceType);
    }

    @Override
    public void updateDeviceType(DeviceType deviceType) throws NoSuchElementException {
        DeviceType existingDeviceType = deviceTypeRepository.findById(Long.valueOf(deviceType.getId())).orElse(null);
        if(existingDeviceType != null){
            existingDeviceType.setDeviceType(deviceType.getDeviceType());
            deviceTypeRepository.save(existingDeviceType);
        }else{
            throw new NoSuchElementException("ERR: Device type with ID " + deviceType.getId() + " does not exist.");
        }
    }

    public DeviceType addDeviceType(String deviceType){
        DeviceTypeResource newDeviceType = new DeviceTypeResource();
        newDeviceType.setDeviceType(deviceType);
        return deviceTypeRepository.save(deviceTypeMapper.fromDeviceTypeResource(newDeviceType));
    }
}