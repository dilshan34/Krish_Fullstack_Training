package com.dilshan.fuel.service;

import com.dilshan.fuel.model.SubmitOrder;
import com.dilshan.fuel.repository.AllOrderRepository;
import com.dilshan.fuel.repository.DispatchOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DispatchOrderImpl implements DispatchOrderService {

    @Autowired
    AllOrderRepository dispatchOrderRepository;

    @Override
    public SubmitOrder save(SubmitOrder submitOrder) {
        return dispatchOrderRepository.save(submitOrder);
    }
}
