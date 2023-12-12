package com.orders.client.service;

import com.orders.client.entity.Service;
import com.orders.client.entity.SubService;
import com.orders.client.repository.ServiceRepository;
import com.orders.client.repository.SubServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class SubServiceTitleImpl implements SubServiceTitle {

    @Autowired
    private SubServiceRepository subServiceRepository;

    @Override
    public SubService addSubService(SubService service) {
        return subServiceRepository.save(service);
    }

    @Override
    public void delete(long id) {
        subServiceRepository.deleteById(id);
    }

    @Override
    public Optional<SubService> getById(Long id) {
        return subServiceRepository.findById(id);
    }

    @Override
    public SubService editSubService(SubService subService) {
        return subServiceRepository.save(subService);
    }

    @Override
    public List<SubService> getSubService() {
        List<SubService> service = (List<SubService>) subServiceRepository.findAll();
        return service;
    }

}
