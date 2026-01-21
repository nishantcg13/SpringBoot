package com.nishant.cms.service;

import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.repository.CmsRepository;
import com.nishant.cms.repository.UserRepository;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


//Order/CmsService
//→ manages orders
//→ place order, update status, fetch orders

@Service
public class CmsService {

    @Autowired
    CmsRepository cmsRepository;

    @Autowired
    UserRepository userRepository;

    public String addOrder(OrderEntity orderEntity,long id) {

        if(!userRepository.existsById(id)) {
            return "User doesn't exist";
        }
        orderEntity.setPlacedDateTime(LocalDateTime.now());
        orderEntity.setUserId(id);
        cmsRepository.save(orderEntity);
        return "Order placed successfully";

    }

    public Optional<OrderEntity> updateOrderStatus(long id, String status) {

        if(!userRepository.existsById(id)){
             return Optional.empty();
        }
        Optional<OrderEntity> getOrder = cmsRepository.findById(id);

        if (getOrder.isEmpty()) {
            return Optional.empty();
        }

        OrderEntity existingOrder = getOrder.get();

        if (!existingOrder.getOrderStatus().equals(status)) {
            existingOrder.setOrderId(id);
            existingOrder.setOrderStatus(status);

            return Optional.of(cmsRepository.save(existingOrder));
        }
        return Optional.empty();
    }

    public List<OrderEntity> getAllOrders(){
        return cmsRepository.findAll();
    }

    public List<OrderEntity> getAllOrderByStatus(String status){
        return cmsRepository.findByOrderStatus(status);
    }

    public Optional<List<OrderEntity>> getAllOrderByDay(LocalDateTime start , LocalDateTime end){
        List<OrderEntity> list = cmsRepository.findByPlacedDateTimeBetween(start,end);

        if(list.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(list);
    }
}
