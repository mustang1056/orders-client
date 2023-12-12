package com.orders.client.controller;

import com.orders.client.entity.Orders;
import com.orders.client.entity.Service;
import com.orders.client.model.OrdersModel;
import com.orders.client.service.OrdersServiceImpl;
import com.orders.client.service.ServiceTitleImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/service/api")
public class ServiceController {
    @Autowired
    ServiceTitleImpl serviceTitle;

    // Получить все записи
    @GetMapping("/service")
    public ResponseEntity<Map<String, Object>> search() {
        List<Service> services = serviceTitle.getService();

        try {
            Map<String, Object> response = new HashMap<>();
            response.put("content", services);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    // Получить запись по id
    @GetMapping("/service/{id}")
    public Optional<Service> findByIds(@PathVariable(value = "id") Long remontId) {
        return (Optional<Service>) serviceTitle.getById(remontId);
    }

    // Создать запись
    @PostMapping("/service")
    public Service createNote(@Valid @RequestBody Service service) {
        return (Service) serviceTitle.addService(service);
    }


} 
