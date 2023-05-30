package org.elsys_bg.ElectronicsRepair.service;

import org.elsys_bg.ElectronicsRepair.entity.Order;

import java.util.List;

public interface OrderService{
    List<Order> findAll();

    Order save(Order order);

    void delete(Order order);

    void updateOrder(Order order);
}