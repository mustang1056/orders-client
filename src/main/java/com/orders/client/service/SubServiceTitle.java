package com.orders.client.service;

import com.orders.client.entity.Service;
import com.orders.client.entity.SubService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface SubServiceTitle {

    SubService addSubService(SubService servieList);

    void delete(long id);

    Optional<SubService> getById(Long id);

    SubService editSubService(SubService service);

    List<SubService> getSubService();

}
