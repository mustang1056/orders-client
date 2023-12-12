package com.orders.client.service;

import com.orders.client.entity.Orders;
import com.orders.client.entity.Service;
import com.orders.client.repository.OrdersRepository;
import com.orders.client.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class ServiceTitleImpl implements ServiceTitle{
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public Service addService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public void delete(long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Optional<Service> getById(Long id) {
        return serviceRepository.findById(id);
    }

    @Override
    public Service editService(Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public List<Service> getService() {
        List<Service> services = (List<Service>) serviceRepository.findAll();
        return services;
    }

}
