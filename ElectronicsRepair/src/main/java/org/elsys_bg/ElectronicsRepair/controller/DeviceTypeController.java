package org.elsys_bg.ElectronicsRepair.controller;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.DeviceType;
import org.elsys_bg.ElectronicsRepair.service.DeviceTypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/device_types")
@RequiredArgsConstructor
public class DeviceTypeController{
    private final DeviceTypeService deviceTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllDeviceTypes(){
        StringBuilder htmlContentBuilder = new StringBuilder();

        try{
            List<DeviceType> deviceTypes = deviceTypeService.findAll();
            deviceTypes.forEach(post -> {
                htmlContentBuilder.append(post.getDeviceType()).append(";");
            });
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String htmlContent = htmlContentBuilder.toString();
        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }
}