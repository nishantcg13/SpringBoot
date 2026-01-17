package com.nishant.cms.controller;

import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/cms")
public class CmsController{

    @Autowired
    CmsService cmsService;

    @PostMapping("/add/{id}")
    public String placeOrder(@RequestBody OrderEntity orderEntity,@PathVariable("id") long id){
        return cmsService.addOrder(orderEntity,id);
    }

    @PutMapping("/admin/updateOrder/{id}/{status}")
    public ResponseEntity<OrderEntity> update(@PathVariable("id") int id , @PathVariable("status") String status){
        return ResponseEntity.of(cmsService.updateOrderStatus(id,status));
    }

    @GetMapping("/user/{userId}/orders")
    public ResponseEntity<List<OrderEntity>> getAllOrders(@PathVariable("userId") long id){
        List<OrderEntity> orders = cmsService.getAllOrdersOfUser(id);

        if(orders.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(orders);
    }

}
