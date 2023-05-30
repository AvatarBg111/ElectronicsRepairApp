package org.elsys_bg.ElectronicsRepair.controller;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.service.impl.OrderServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@RequiredArgsConstructor
public class OrderController{
    private final OrderServiceImpl orderService;

    @GetMapping("/getAll")
    public ResponseEntity<String> getAllOrders(){
        String htmlContent = "";

        try{
            htmlContent = orderService.getAllOrders().toString();
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }

    /*
    @PostMapping("/add_order")
    public ResponseEntity<String> addOrder(){
        String htmlContent = "";

        try{
            htmlContent = clientService.findAll().toString();
        }catch(Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error 500: Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(htmlContent, HttpStatus.OK);
    }
    */
}