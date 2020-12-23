package com.example.demo.Bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Alias("Order")
@Data
@Component
public class Order {
    private String userid;
    private String shopId;
    private int shopnumber;
    private double discount;
    private String address;
    private String time;
    private double allprice;
    private String cancel;
    private Goods goods;
}
