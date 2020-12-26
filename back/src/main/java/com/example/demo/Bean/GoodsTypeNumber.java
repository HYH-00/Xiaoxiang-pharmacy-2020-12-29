package com.example.demo.Bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Component
@Alias("GoodsTypeNUmber")
public class GoodsTypeNumber {
    private String type;
    private int number;
    private double amount;
    private double discount;
}
