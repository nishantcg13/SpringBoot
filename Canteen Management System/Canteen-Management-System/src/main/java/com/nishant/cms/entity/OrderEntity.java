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

    public OrderEntity(){
        super();
    }

    public OrderEntity(long orderId , String orderMenu , String orderStatus, long userId,LocalDateTime placedDateTime , float totalAmount){
        this.orderId = orderId;
        this.orderMenu = orderMenu;
        this.orderStatus = orderStatus;
        this.userId = userId;
        this.placedDateTime = placedDateTime;
        this.totalAmount = totalAmount;
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

    public void setUserId(long customerName) {
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
}


