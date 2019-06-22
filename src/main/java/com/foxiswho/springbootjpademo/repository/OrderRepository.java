package com.foxiswho.springbootjpademo.repository;

import com.foxiswho.springbootjpademo.model.Orders;
import com.foxiswho.springbootjpademo.support.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<Orders, Long> {
}
