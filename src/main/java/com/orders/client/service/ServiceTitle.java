package com.orders.client.service;

import com.orders.client.entity.Orders;
import com.orders.client.entity.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ServiceTitle {

    Service addService(Service servieList);

    void delete(long id);

    Optional<Service> getById(Long id);

    Service editService(Service service);

    List<Service> getService();

}
