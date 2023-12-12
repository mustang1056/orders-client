package com.orders.client.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity(name = "orders")
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String comment;

    private Double cost;

    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date date_time;

    private int service_id;

    private int sub_service_id;

    private int user_id;

    private transient String service_title;

    private String phone_number;

    private String avatar_image;

}