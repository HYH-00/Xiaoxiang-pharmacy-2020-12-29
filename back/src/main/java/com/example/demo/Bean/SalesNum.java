package com.example.demo.Bean;

import lombok.Data;

/**
 * 对应时间的销量
 */
@Data
public class SalesNum {
    private String time;
    private int num;
    private String type;
    private String type_;
}