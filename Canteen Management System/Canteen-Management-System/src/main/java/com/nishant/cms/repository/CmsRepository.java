package com.nishant.cms.repository;

import com.nishant.cms.entity.OrderEntity;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CmsRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findByUserId(long id);

    List<OrderEntity> findByOrderStatus(String status);

    List<OrderEntity> findByPlacedDateTimeBetween(LocalDateTime start , LocalDateTime end);
}
