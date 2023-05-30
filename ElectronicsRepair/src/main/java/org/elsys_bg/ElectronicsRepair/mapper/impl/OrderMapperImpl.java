package org.elsys_bg.ElectronicsRepair.mapper.impl;

import org.elsys_bg.ElectronicsRepair.controller.resources.OrderResource;
import org.elsys_bg.ElectronicsRepair.entity.Client;
import org.elsys_bg.ElectronicsRepair.entity.Order;
import org.elsys_bg.ElectronicsRepair.mapper.OrderMapper;
import org.elsys_bg.ElectronicsRepair.miscellaneous.ClientProjection;
import org.elsys_bg.ElectronicsRepair.miscellaneous.OrdersProjection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapperImpl implements OrderMapper{
    @Override
    public Order fromOrderResource(OrderResource orderResource){
        if(orderResource == null){
            return null;
        }

        Order order = new Order();
        order.setId(orderResource.getId());
        order.setClient(orderResource.getClient());
        order.setSupportedDeviceType(orderResource.getSupportedDeviceType());
        order.setModel(orderResource.getModel());
        order.setDescription(orderResource.getDescription());
        order.setOrderStatus(orderResource.getOrderStatus());
        return order;
    }

    @Override
    public OrderResource toOrderResource(Order order){
        if(order == null){
            return null;
        }

        OrderResource orderResource = new OrderResource();
        orderResource.setId(order.getId());
        orderResource.setClient(order.getClient());
        orderResource.setSupportedDeviceType(order.getSupportedDeviceType());
        orderResource.setModel(order.getModel());
        orderResource.setDescription(order.getDescription());
        orderResource.setOrderStatus(order.getOrderStatus());
        return orderResource;
    }

    @Override
    public OrderResource fromOrderProjection(OrdersProjection orderProjection){
        if(orderProjection == null){
            return null;
        }

        OrderResource orderResource = new OrderResource();
        orderResource.setId(orderProjection.getId());
        orderResource.setClient(ClientMapperImpl.MAPPER.fromClientProjection(orderProjection.getClient()));
        orderResource.setSupportedDeviceType(SupportedDeviceForRepairMapperImpl.MAPPER.fromSupportedDeviceForRepairProjection(orderProjection.getSupportedDeviceType()));
        orderResource.setModel(orderProjection.getModel());
        orderResource.setDescription(orderProjection.getDescription());
        orderResource.setOrderStatus(OrderStatusMapperImpl.MAPPER.fromOrderStatusProjection(orderProjection.getOrderStatus()));
        return orderResource;
    }

    @Override
    public List<OrderResource> toOrderResources(List<Order> orders){
        if(orders == null){
            return null;
        }

        return orders.stream()
                .map(this::toOrderResource)
                .collect(Collectors.toList());
    }
}