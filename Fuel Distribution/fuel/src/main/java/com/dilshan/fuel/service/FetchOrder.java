package com.dilshan.fuel.service;

import com.dilshan.fuel.model.Fuel;

import java.util.List;

public interface FetchOrder {
    List<Fuel> fetchAllOrders();

     List<Fuel> findById(int id);

     List<Fuel> AllOrders();
}
