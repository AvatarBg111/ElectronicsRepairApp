package org.elsys_bg.ElectronicsRepair.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.*;
import org.elsys_bg.ElectronicsRepair.miscellaneous.CustomFileReader;
import org.elsys_bg.ElectronicsRepair.service.impl.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admins")
@RequiredArgsConstructor
public class AdminController{
    private final AdminServiceImpl adminService;
    private final WorkerServiceImpl workerService;
    private final WorkerPostServiceImpl workerPostService;
    private final DeviceTypeServiceImpl deviceTypeService;
    private final SupportedDeviceForRepairServiceImpl supportedDeviceTypeService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllAdmins(){
        String htmlContent = "";

        try{
            htmlContent = adminService.findAll().toString();
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }

    @PostMapping("/admin_exists")
    public ResponseEntity<String> checkAdminExists(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String username = jsonNode.get("user").asText();

            if(adminService.adminExists(username)){
                return new ResponseEntity<>("USER_EXISTS", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("USER_NOT_EXISTS", HttpStatus.OK);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 400: Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/admin_login")
    public ResponseEntity<String> adminLogIn(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String username = jsonNode.get("user").asText();
            String password = jsonNode.get("pass").asText();

            if(adminService.checkAdminPassword(username, password)){
                return new ResponseEntity<>("USER_LOGGED_IN", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("ADMIN_PASSWORD_INCORRECT", HttpStatus.OK);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 400: Bad Request", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/admin_signup")
    public ResponseEntity<String> adminSignUp(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            JsonNode jsonNode = objectMapper.readTree(json);
            String username = jsonNode.get("user").asText();
            String password = jsonNode.get("pass").asText();
            String adminUsername = jsonNode.get("adminUsername").asText();
            String adminPassword = jsonNode.get("adminPassword").asText();
            Admin admin;

            admin = adminService.signUp(username, password);
            if(admin != null){
                return new ResponseEntity<>("ADMIN_SIGNED_UP", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("ADMIN_NOT_SIGNED_UP", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/admin_homepage")
    public ResponseEntity<String> getAdminHomepage(@RequestParam("username") String username){
        String htmlContent = "";
        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.TEXT_HTML);
        try{
            htmlContent = CustomFileReader.readFile(System.getProperty("user.dir") + "/src/main/java/org/elsys_bg/ElectronicsRepair/htmlPages/admin_homepage.html");
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", headers, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        htmlContent = htmlContent.replace("__USERNAME__", username);

        return new ResponseEntity<>(htmlContent, headers, HttpStatus.OK);
    }

    @PostMapping("/add_worker_post")
    public ResponseEntity<String> addWorkerPost(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String workerPost = jsonNode.get("workerPost").asText();

            WorkerPost post = workerPostService.addWorkerPost(workerPost);
            if(post != null){
                return new ResponseEntity<>("WORKER_POST_ADDED", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("WORKER_POST_NOT_ADDED", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add_worker")
    public ResponseEntity<String> addWorker(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String workerPost = jsonNode.get("workerPost").asText();
            String workerName = jsonNode.get("workerName").asText();
            String workerPassword = jsonNode.get("workerPassword").asText();

            Worker post = workerService.signUp(workerName, workerPassword, workerPostService.getByPost(workerPost));
            if(post != null){
                return new ResponseEntity<>("WORKER__ADDED", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("WORKER_NOT_ADDED", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add_device_type")
    public ResponseEntity<String> addDeviceType(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String deviceType = jsonNode.get("deviceType").asText();

            DeviceType device = deviceTypeService.addDeviceType(deviceType);
            if(device != null){
                return new ResponseEntity<>("DEVICE_TYPE_ADDED", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("DEVICE_TYPE_NOT_ADDED", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/add_supported_device_for_repair")
    public ResponseEntity<String> addSupportedDeviceForRepair(@RequestBody String json){
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            JsonNode jsonNode = objectMapper.readTree(json);
            String deviceManufacturer = jsonNode.get("deviceManufacturer").asText();
            DeviceType deviceType = deviceTypeService.getByDevice(jsonNode.get("deviceType").asText());

            if(supportedDeviceTypeService.getDeviceByTypeAndManufacturer(deviceManufacturer, deviceType) != null){
                return new ResponseEntity<>("SUPPORTED_DEVICE_ALREADY_EXISTS", HttpStatus.OK);
            }

            SupportedDeviceForRepair supportedDevice = supportedDeviceTypeService.addSupportedDevice(deviceManufacturer, deviceType);
            if(supportedDevice != null){
                return new ResponseEntity<>("SUPPORTED_DEVICE_ADDED", HttpStatus.OK);
            }else{
                return new ResponseEntity<>("SUPPORTED_DEVICE_NOT_ADDED", HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>(String.valueOf(e), HttpStatus.BAD_REQUEST);
        }
    }
}