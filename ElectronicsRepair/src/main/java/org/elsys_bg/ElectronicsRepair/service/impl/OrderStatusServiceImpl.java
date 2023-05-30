package org.elsys_bg.ElectronicsRepair.service.impl;

import lombok.RequiredArgsConstructor;
import org.elsys_bg.ElectronicsRepair.entity.OrderStatus;
import org.elsys_bg.ElectronicsRepair.mapper.OrderStatusMapper;
import org.elsys_bg.ElectronicsRepair.repository.OrderStatusRepository;
import org.elsys_bg.ElectronicsRepair.service.OrderStatusService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService{
    public final OrderStatusRepository orderStatusRepository;
    private final OrderStatusMapper orderStatusMapper;

    public OrderStatus getById(Long orderStatusId){
        return orderStatusRepository.getById(orderStatusId);
    }

    public OrderStatus getByStatus(String orderStatus){
        return orderStatusRepository.getByStatus(orderStatus);
    }

    @Override
    public List<OrderStatus> findAll(){
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus){
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void delete(OrderStatus orderStatus){
        orderStatusRepository.delete(orderStatus);
    }

    @Override
    public void updateOrderStatus(OrderStatus orderStatus) throws NoSuchElementException {
        OrderStatus existingOrderStatus = orderStatusRepository.findById(Long.valueOf(orderStatus.getId())).orElse(null);
        if(existingOrderStatus != null){
            existingOrderStatus.setOrderStatus(orderStatus.getOrderStatus());
            orderStatusRepository.save(existingOrderStatus);
        }else{
            throw new NoSuchElementException("ERR: Order status with ID " + orderStatus.getId() + " does not exist.");
        }
    }
}