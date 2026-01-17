package com.nishant.cms.repository;

import com.nishant.cms.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CmsRepository extends JpaRepository<OrderEntity,Long> {

    List<OrderEntity> findByUserId(long id);
}
