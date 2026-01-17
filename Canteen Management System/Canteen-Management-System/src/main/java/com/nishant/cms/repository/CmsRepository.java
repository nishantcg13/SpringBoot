package com.nishant.cms.repository;

import com.nishant.cms.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CmsRepository extends JpaRepository<OrderEntity,Long> {
}
