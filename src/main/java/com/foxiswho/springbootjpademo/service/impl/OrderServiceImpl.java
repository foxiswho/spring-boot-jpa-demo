package com.foxiswho.springbootjpademo.service.impl;

import com.foxiswho.springbootjpademo.model.Orders;
import com.foxiswho.springbootjpademo.repository.OrderRepository;
import com.foxiswho.springbootjpademo.service.OrderService;
import com.foxiswho.springbootjpademo.support.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl extends BaseServiceImpl<Orders,Long, OrderRepository> implements OrderService {
}
