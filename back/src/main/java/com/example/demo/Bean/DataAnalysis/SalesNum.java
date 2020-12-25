package com.example.demo.Bean.DataAnalysis;

import lombok.Data;

/**
 * 对应时间的销量
 */
@Data
public class SalesNum {
    private String month;
    private int num;
    private String type;
    private String year;
}