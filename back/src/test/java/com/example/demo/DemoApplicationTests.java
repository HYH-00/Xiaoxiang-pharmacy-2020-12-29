package com.example.demo;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.Order;
import com.example.demo.Service.GoodsService;
import com.example.demo.Service.UserInformationService;
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
    @Autowired
    UserInformationService userInformationService;
    @Test
    void contextLoads() {
        List<GoodsTypeNumber> orders = userInformationService.userDataAnalysisService("洵哥喜欢短头发小姐姐");
    }

}
