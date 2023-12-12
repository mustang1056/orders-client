package com.orders.client.repository;

import com.orders.client.entity.Orders;
import com.orders.client.entity.Service;
import com.orders.client.model.OrdersModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {

    /*
    @Query(value = "SELECT id, title FROM service LEFT joi", nativeQuery = true)
    List<Service> getService();
    */
    @Query(value = "SELECT ord.id, ord.title, ord.comment, ord.cost, DATE_FORMAT(ord.date_time, '%Y-%m-%d %H:%i:%s') AS date_time, ord.service_id, ord.sub_service_id, ord.user_id, ord.phone_number, ord.avatar_image, srv.title AS service_title\n" +
            "\t\tFROM orders AS ord LEFT JOIN service AS srv ON ord.service_id = srv.id", nativeQuery = true)
    Page<OrdersModel> getService(Pageable pageable);


    @Query(value = "SELECT ord.id, ord.title, ord.comment, ord.cost, DATE_FORMAT(ord.date_time, '%Y-%m-%d %H:%i:%s') AS date_time, ord.service_id, ord.sub_service_id, ord.user_id, ord.phone_number, ord.avatar_image, srv.title AS service_title\n" +
            "\t\tFROM orders AS ord LEFT JOIN service AS srv ON ord.service_id = srv.id WHERE srv.id IN (:ids)", nativeQuery = true)
    Page<OrdersModel> getServiceById(Pageable pageable, @Param("ids") List<String> ids);

}
