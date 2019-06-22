package com.foxiswho.springbootjpademo.controller;

import com.foxiswho.springbootjpademo.model.Orders;
import com.foxiswho.springbootjpademo.repository.OrderRepository;
import com.foxiswho.springbootjpademo.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/create")
    public String create() {

        Long id = System.currentTimeMillis();
        Orders order = new Orders();
        // order.setId(System.currentTimeMillis());
        order.setIdCustomPrimaryKey(id);
        order.setNo(id + "");
        log.info(" id= {}", order.getId());
        log.info(" order= {}", order);
        Orders orders2 = orderRepository.save(order);

        log.info(" insert return order2= {}", orders2);

        id = System.currentTimeMillis();
        order = new Orders();
        order.setIdCustomPrimaryKey(id);
        order.setNo(id + "2");
        Orders orders3 = orderService.saveOne(order);
        log.info(" insert return order3= {}", orders3);
        return "create";
    }


    @GetMapping("/update")
    public String update(@RequestParam("id") Long id) {
        log.info("get id= {}", id);
        Orders order = new Orders();
        order.setId(id);
        order.setNo("update-" + System.currentTimeMillis());
        log.info(" id= {}", order.getId());
        log.info(" order= {}", order);

        orderRepository.save(order);

        return "update";
    }
}
