package com.orders.client.controller;

import com.orders.client.entity.Orders;
import com.orders.client.model.OrdersModel;
import com.orders.client.service.OrdersServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.*;

@RestController
@RequestMapping("/orders/api")
public class OrdersController {
    @Autowired
    OrdersServiceImpl orderService;

    // Получить все записи
    @GetMapping("/orders")
    public ResponseEntity<Page<OrdersModel>> search(@RequestParam(name = "page") int pageNumber) {
        try {
            int pageSize = 20;
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<OrdersModel> remonts = orderService.getOrders(pageable);

            Map<String, Object> response = new HashMap<>();
            response.put("orders", remonts);

            return new ResponseEntity<>(remonts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Получить все записи по id
    @GetMapping("/orders_service")
    public ResponseEntity<Page<OrdersModel>> searchByIds(@RequestParam(name = "page") int pageNumber, @RequestParam(name = "ids") String ids) {
        try {
            int pageSize = 20;
            List<String> idsList = new ArrayList<>();
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            ids = decode(ids);
            ids = ids.replace("]", "");
            ids = ids.replace("[", "");

            //System.out.println("dewdwdwd"+ids);
            if(ids.length() > 1) {
                idsList = new ArrayList<String>(Arrays.asList(ids.split(",")));
            }
            else{
                idsList = new ArrayList<String>(Arrays.asList(ids));
            }

            Page<OrdersModel> remonts = orderService.getOrdersByIds(pageable, idsList);

            Map<String, Object> response = new HashMap<>();
            response.put("orders", remonts);

            return new ResponseEntity<>(remonts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Получить запись по id
    @GetMapping("/order/{id}")
    public Optional<Orders> findByIds(@PathVariable(value = "id") Long remontId) {
        return (Optional<Orders>) orderService.getById(remontId);
    }

    // Создать запись
    @PostMapping("/order")
    public Orders createNote(@Valid @RequestBody Orders order) {
        return (Orders) orderService.addOrder(order);
    }


    private String decode(String value) throws UnsupportedEncodingException {
        return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
    }


}
