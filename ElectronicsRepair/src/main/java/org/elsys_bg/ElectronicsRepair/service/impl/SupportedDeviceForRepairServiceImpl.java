package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.controller.resources.SupportedDeviceForRepairResource;
import org.elsys_bg.ElectronicsRepair.controller.resources.WorkerResource;
import org.elsys_bg.ElectronicsRepair.entity.DeviceType;
import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;
import org.elsys_bg.ElectronicsRepair.mapper.SupportedDeviceForRepairMapper;
import org.elsys_bg.ElectronicsRepair.mapper.impl.SupportedDeviceForRepairMapperImpl;
import org.elsys_bg.ElectronicsRepair.miscellaneous.SupportedDevicesProjection;
import org.elsys_bg.ElectronicsRepair.repository.SupportedDeviceForRepairRepository;
import org.elsys_bg.ElectronicsRepair.service.SupportedDeviceForRepairService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class SupportedDeviceForRepairServiceImpl implements SupportedDeviceForRepairService{
    public final SupportedDeviceForRepairRepository supportedDeviceForRepairRepository;
    public final SupportedDeviceForRepairMapper supportedDeviceForRepairMapper;

    public SupportedDeviceForRepair getById(Long supportedDeviceForRepairId){
        return supportedDeviceForRepairRepository.getById(supportedDeviceForRepairId);
    }

    public List<SupportedDevicesProjection> getAllDevices(){
        return supportedDeviceForRepairRepository.getAllDevices();
    }

    public SupportedDeviceForRepair getDeviceByTypeAndManufacturer(String manufacturer, DeviceType deviceType){
        return supportedDeviceForRepairRepository.getDeviceByTypeAndManufacturer(manufacturer, deviceType);
    }

    @Override
    public List<SupportedDeviceForRepair> findAll(){
        return supportedDeviceForRepairRepository.findAll();
    }

    @Override
    public SupportedDeviceForRepair save(SupportedDeviceForRepair supportedDeviceForRepair){
        return supportedDeviceForRepairRepository.save(supportedDeviceForRepair);
    }

    @Override
    public void delete(SupportedDeviceForRepair device){
        supportedDeviceForRepairRepository.delete(device);
    }

    @Override
    public void updateSupportedDeviceForRepair(SupportedDeviceForRepair device) throws NoSuchElementException {
        SupportedDeviceForRepair existingDevice = supportedDeviceForRepairRepository.findById(Long.valueOf(device.getId())).orElse(null);
        if(existingDevice != null){
            existingDevice.setDeviceType(device.getDeviceType());
            existingDevice.setManufacturer(device.getManufacturer());
            supportedDeviceForRepairRepository.save(existingDevice);
        }else{
            throw new NoSuchElementException("ERR: SupportedDeviceForRepair with ID " + device.getId() + " does not exist.");
        }
    }

    public SupportedDeviceForRepair addSupportedDevice(String deviceManufacturer, DeviceType deviceType){
        SupportedDeviceForRepairResource newSupportedDevice = new SupportedDeviceForRepairResource();
        newSupportedDevice.setDeviceType(deviceType);
        newSupportedDevice.setManufacturer(deviceManufacturer);
        return supportedDeviceForRepairRepository.save(supportedDeviceForRepairMapper.fromSupportedDeviceForRepairResource(newSupportedDevice));
    }
}