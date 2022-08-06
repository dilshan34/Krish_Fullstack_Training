package com.dilshan.fuel.service;

import com.dilshan.fuel.model.Fuel;
import com.dilshan.fuel.repository.DispatchOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FetchOrderService implements FetchOrder{

    @Autowired
    DispatchOrderRepository dispatchOrderRepository;

    public List<Fuel> fetchAllOrders(){
        return dispatchOrderRepository.findAll();
    }

    public List<Fuel> AllOrders(){
        return dispatchOrderRepository.findAllOrders();
    }

    @Override
    public List<Fuel> findById(int id) {
        return dispatchOrderRepository.findById(id);
    }


}
