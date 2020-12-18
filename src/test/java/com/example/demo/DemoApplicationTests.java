package com.example.demo;

import com.example.demo.Bean.Goods;
import com.example.demo.Service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DemoApplicationTests {
    @Autowired
    GoodsService service;
    @Test
    void contextLoads() {
        List<Goods> goods = service.findAllDiscountGoodsService();
        for(Goods goods1 : goods){
            System.out.println(goods1.toString());
        }
    }

}
