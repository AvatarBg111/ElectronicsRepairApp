package org.elsys_bg.ElectronicsRepair.controller;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.miscellaneous.SupportedDevicesProjection;
import org.elsys_bg.ElectronicsRepair.service.impl.AdminServiceImpl;
import org.elsys_bg.ElectronicsRepair.service.impl.SupportedDeviceForRepairServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/supported_devices")
@RequiredArgsConstructor
public class SupportedDeviceForRepairController{
    private final SupportedDeviceForRepairServiceImpl supportedDeviceService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllAdmins(){
        StringBuilder htmlContentBuilder = new StringBuilder();

        try{
            List<SupportedDevicesProjection> devices = supportedDeviceService.getAllDevices();
            devices.forEach(device -> {
                htmlContentBuilder.append("Manufacturer: ").append(device.getManufacturer()).append("\tDevice type: ").append(device.getDeviceType()).append("\n");
            });
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String htmlContent = htmlContentBuilder.toString();
        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }
}