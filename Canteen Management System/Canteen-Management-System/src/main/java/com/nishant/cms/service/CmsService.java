package com.nishant.cms.service;

import com.nishant.cms.entity.OrderEntity;
import com.nishant.cms.repository.CmsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CmsService {

    @Autowired
    CmsRepository cmsRepository;

    public String addOrder(OrderEntity orderEntity,long id) {
        orderEntity.setPlacedDateTime(LocalDateTime.now());
        orderEntity.setUserId(id);
        cmsRepository.save(orderEntity);
        return "Order placed successfully";
    }

    public Optional<OrderEntity> updateOrderStatus(long id, String status) {

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


}
