package com.example.demo;

import com.example.demo.Bean.Goods;
import com.example.demo.Bean.Order;
import com.example.demo.Dao.UserDao;
import com.example.demo.Service.GoodsService;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    GoodsService service;
    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
       List<Order> orders = userService.findAllOrderByUserIdService("洵哥喜欢短头发小姐姐");
       for(Order order :orders){
           System.out.println(order);
       }
    }

}
