package com.foxiswho.springbootjpademo.service;

import com.foxiswho.springbootjpademo.model.Orders;
import com.foxiswho.springbootjpademo.repository.OrderRepository;
import com.foxiswho.springbootjpademo.support.BaseService;

public interface OrderService extends BaseService<Orders,Long, OrderRepository> {
}
