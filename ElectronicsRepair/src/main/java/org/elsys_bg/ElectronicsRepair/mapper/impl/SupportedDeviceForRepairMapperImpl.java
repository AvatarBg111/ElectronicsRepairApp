package org.elsys_bg.ElectronicsRepair.mapper.impl;

import org.elsys_bg.ElectronicsRepair.controller.resources.SupportedDeviceForRepairResource;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.entity.SupportedDeviceForRepair;
import org.elsys_bg.ElectronicsRepair.mapper.SupportedDeviceForRepairMapper;
import org.elsys_bg.ElectronicsRepair.miscellaneous.ClientProjection;
import org.elsys_bg.ElectronicsRepair.miscellaneous.SupportedDeviceForRepairProjection;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class SupportedDeviceForRepairMapperImpl implements SupportedDeviceForRepairMapper{
    @Override
    public SupportedDeviceForRepair fromSupportedDeviceForRepairResource(SupportedDeviceForRepairResource supportedDeviceForRepairResource){
        if(supportedDeviceForRepairResource == null){
            return null;
        }

        SupportedDeviceForRepair supportedDeviceForRepair = new SupportedDeviceForRepair();
        supportedDeviceForRepair.setId(supportedDeviceForRepairResource.getId());
        supportedDeviceForRepair.setDeviceType(supportedDeviceForRepairResource.getDeviceType());
        supportedDeviceForRepair.setManufacturer(supportedDeviceForRepairResource.getManufacturer());

        return supportedDeviceForRepair;
    }

    @Override
    public SupportedDeviceForRepairResource toSupportedDeviceForRepairResource(SupportedDeviceForRepair supportedDeviceForRepair){
        if(supportedDeviceForRepair == null){
            return null;
        }

        SupportedDeviceForRepairResource supportedDeviceForRepairResource = new SupportedDeviceForRepairResource();
        supportedDeviceForRepairResource.setId(supportedDeviceForRepair.getId());
        supportedDeviceForRepairResource.setDeviceType(supportedDeviceForRepair.getDeviceType());
        supportedDeviceForRepairResource.setManufacturer(supportedDeviceForRepair.getManufacturer());

        return supportedDeviceForRepairResource;
    }

    @Override
    public List<SupportedDeviceForRepairResource> toSupportedDeviceForRepairResources(List<SupportedDeviceForRepair> supportedDevicesForRepair){
        if(supportedDevicesForRepair == null){
            return Collections.emptyList();
        }

        List<SupportedDeviceForRepairResource> supportedDeviceForRepairResources = new ArrayList<>();
        for(SupportedDeviceForRepair supportedDeviceForRepair : supportedDevicesForRepair){
            supportedDeviceForRepairResources.add(toSupportedDeviceForRepairResource(supportedDeviceForRepair));
        }

        return supportedDeviceForRepairResources;
    }

    @Override
    public SupportedDeviceForRepair fromSupportedDeviceForRepairProjection(SupportedDeviceForRepairProjection supportedDeviceForRepairProjection){
        SupportedDeviceForRepair supportedDeviceForRepair = new SupportedDeviceForRepair();
        supportedDeviceForRepair.setId(supportedDeviceForRepairProjection.getId());
        supportedDeviceForRepair.setManufacturer(supportedDeviceForRepairProjection.getManufacturer());
        supportedDeviceForRepair.setDeviceType(DeviceTypeMapperImpl.MAPPER.fromDeviceTypeProjection(supportedDeviceForRepairProjection.getDeviceType()));
        return supportedDeviceForRepair;
    }
}