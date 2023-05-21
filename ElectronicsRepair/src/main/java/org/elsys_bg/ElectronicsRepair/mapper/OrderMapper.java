package org.elsys_bg.ElectronicsRepair.mapper;

import org.elsys_bg.ElectronicsRepair.controller.resources.OrderResource;
import org.elsys_bg.ElectronicsRepair.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderMapper{
    OrderMapper MAPPER = Mappers.getMapper(OrderMapper.class);

    @Mapping(target = "id", source = "orderResource.id")
    @Mapping(target = "client", source = "orderResource.client")
    @Mapping(target = "supportedDeviceType", source = "orderResource.supportedDeviceType")
    @Mapping(target = "model", source = "orderResource.model")
    @Mapping(target = "specifications", source = "orderResource.specifications")
    Order fromOrderResource(OrderResource orderResource);

    @Mapping(target = "id", source = "order.id")
    @Mapping(target = "client", source = "order.client")
    @Mapping(target = "supportedDeviceType", source = "order.supportedDeviceType")
    @Mapping(target = "model", source = "order.model")
    @Mapping(target = "specifications", source = "order.specifications")
    OrderResource toOrderResource(Order order);

    List<OrderResource> toOrderResources(List<Order> orders);
}