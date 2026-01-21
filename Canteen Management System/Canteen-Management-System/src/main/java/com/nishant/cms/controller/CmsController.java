package com.nishant.cms.controller;

import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.service.CmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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

    @GetMapping("admin/getAll")
    public ResponseEntity<List<OrderEntity>> getAll(){
         return ResponseEntity.ok(cmsService.getAllOrders());
    }

    @GetMapping("admin/byStatus/{status}")
    public ResponseEntity<List<OrderEntity>> getByStatus(@PathVariable String status){
        return ResponseEntity.ok(cmsService.getAllOrderByStatus(status));
    }

    @GetMapping("admin/orders/today")
    public ResponseEntity<List<OrderEntity>> getByDay(){
        LocalDate today = LocalDate.now();

        LocalDateTime startOfDay = today.atStartOfDay();
        LocalDateTime endOfDay = today.atTime(LocalTime.MAX);
        return ResponseEntity.of(cmsService.getAllOrderByDay(startOfDay , endOfDay));
    }
}
