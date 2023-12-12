package com.orders.client.controller;

import com.orders.client.entity.Service;
import com.orders.client.entity.SubService;
import com.orders.client.service.ServiceTitleImpl;
import com.orders.client.service.SubServiceTitleImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubServiceController {
    @Autowired
    SubServiceTitleImpl subServiceTitle;

    // Получить все записи
    @GetMapping("/sub_service")
    public List<SubService> search() {
        List<SubService> services = subServiceTitle.getSubService();
        return services;
    }

    // Получить запись по id
    @GetMapping("/sub_service/{id}")
    public Optional<SubService> findByIds(@PathVariable(value = "id") Long remontId) {
        return (Optional<SubService>) subServiceTitle.getById(remontId);
    }

    // Создать запись
    @PostMapping("/sub_service")
    public SubService createNote(@Valid @RequestBody SubService service) {
        return (SubService) subServiceTitle.addSubService(service);
    }

}
