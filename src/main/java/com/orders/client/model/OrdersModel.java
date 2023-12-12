package com.orders.client.model;

import java.util.Date;

public interface OrdersModel {
    int getId();
    String getTitle();
    String getComment();
    Double getCost();
    String getDate_time();
    int getService_Id();
    int getSub_service_id();
    int getUser_id();
    String getService_title();
    String getPhone_number();
    String getAvatar_image();
}
