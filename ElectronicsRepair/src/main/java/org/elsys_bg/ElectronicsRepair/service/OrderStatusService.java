package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.OrderStatus;

import java.util.List;

public interface OrderStatusService{
    List<OrderStatus> findAll();

    OrderStatus save(OrderStatus orderStatus);

    void delete(OrderStatus orderStatus);
    void updateOrderStatus(OrderStatus orderStatus);
}