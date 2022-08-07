package com.dilshan.fuel.repository;

import com.dilshan.fuel.model.SubmitOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface AllOrderRepository extends JpaRepository<SubmitOrder,Integer> {

    SubmitOrder save( SubmitOrder submitOrder);
}
