package com.example.demo;

import com.example.demo.Bean.Order;
import com.example.demo.Service.GoodsService;
import com.example.demo.Service.UserOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    GoodsService service;
    @Autowired
    UserOrderService userOrderService;
    @Test
    void contextLoads() {
       List<Order> orders = userOrderService.findAllOrderByUserIdService("洵哥喜欢短头发小姐姐");
       for(Order order :orders){
           System.out.println(order);
       }
    }

}
