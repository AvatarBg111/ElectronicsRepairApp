package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.controller.resources.OrderResource;
import org.elsys_bg.ElectronicsRepair.entity.Order;
import org.elsys_bg.ElectronicsRepair.mapper.OrderMapper;
import org.elsys_bg.ElectronicsRepair.miscellaneous.OrdersProjection;
import org.elsys_bg.ElectronicsRepair.repository.OrderRepository;
import org.elsys_bg.ElectronicsRepair.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    public final OrderRepository orderRepository;
    public final OrderMapper orderMapper;

    public Order getById(Long orderId){
        return orderRepository.getById(orderId);
    }

    public List<Order> getAllOrders(){
        return orderRepository.getAllOrders();
    }

    @Override
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order){
        return orderRepository.save(order);
    }

    @Override
    public void delete(Order order){
        orderRepository.delete(order);
    }

    @Override
    public void updateOrder(Order order) throws NoSuchElementException {
        Order existingOrder = orderRepository.findById(Long.valueOf(order.getId())).orElse(null);
        if(existingOrder != null){
            existingOrder.setClient(order.getClient());
            existingOrder.setSupportedDeviceType(order.getSupportedDeviceType());
            existingOrder.setModel(order.getModel());
            existingOrder.setDescription(order.getDescription());
            existingOrder.setOrderStatus(order.getOrderStatus());
            orderRepository.save(existingOrder);
        }else{
            throw new NoSuchElementException("ERR: Order with ID " + order.getId() + " does not exist.");
        }
    }
}