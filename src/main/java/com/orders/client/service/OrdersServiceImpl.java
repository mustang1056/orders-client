package com.orders.client.service;

import com.orders.client.entity.Orders;
import com.orders.client.model.OrdersModel;
import com.orders.client.repository.OrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class OrdersServiceImpl implements OrdersService {

    @Autowired
    private OrdersRepository ordersRepository;

    @Override
    public Orders addOrder(Orders order) {
        return ordersRepository.save(order);
    }

    @Override
    public void delete(long id) {
        ordersRepository.deleteById(id);
    }

    @Override
    public Optional<Orders> getById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders editOrder(Orders bank) {
        return ordersRepository.save(bank);
    }

    @Override
    public Page<OrdersModel> getOrders(Pageable pageable) {
        Page orders = (Page) ordersRepository.getService(pageable);
        return orders;
    }

    @Override
    public Page<OrdersModel> getOrdersByIds(Pageable pageable, List<String> ids){
        Page orders = (Page) ordersRepository.getServiceById(pageable, ids);
        return orders;
    }

}
