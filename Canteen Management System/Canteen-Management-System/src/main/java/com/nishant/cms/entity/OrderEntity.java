package com.nishant.cms.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class OrderEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;
    private String orderMenu;
    private String orderStatus;
    private long userId;
    private LocalDateTime placedDateTime;
    private float totalAmount;
    private long restaurantId;


    public OrderEntity(){
        super();
    }

    public OrderEntity(long orderId , long userId, String orderMenu , String orderStatus,LocalDateTime placedDateTime , float totalAmount , long restaurantId){
        this.orderId = orderId;
        this.orderMenu = orderMenu;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.placedDateTime = placedDateTime;
        this.totalAmount = totalAmount;
        this.restaurantId = restaurantId;
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getOrderMenu() {
        return orderMenu;
    }

    public void setOrderMenu(String orderMenu) {
        this.orderMenu = orderMenu;
    }

    public LocalDateTime getPlacedDateTime() {
        return placedDateTime;
    }

    public void setPlacedDateTime(LocalDateTime placedDateTime) {
        this.placedDateTime = placedDateTime;
    }

    public float getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(float totalAmount) {
        this.totalAmount = totalAmount;
    }
    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long restaurantId) {
        this.restaurantId = restaurantId;
    }

}


