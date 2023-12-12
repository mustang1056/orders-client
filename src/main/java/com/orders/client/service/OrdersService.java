package com.orders.client.service;

import com.orders.client.entity.Orders;
import com.orders.client.model.OrdersModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface OrdersService {

    Orders addOrder(com.orders.client.entity.Orders orderList);

    void delete(long id);

    Optional<Orders> getById(Long id);

    Orders editOrder(Orders order);

    Page<OrdersModel> getOrders(Pageable pageable);

    Page<OrdersModel> getOrdersByIds(Pageable pageable, List<String> ids);

    //User convertToUserDto(UserEntity user);
}
