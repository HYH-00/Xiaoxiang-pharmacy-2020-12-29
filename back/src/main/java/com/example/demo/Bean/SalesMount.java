package com.example.demo.Bean;

import lombok.Data;

/**
 * 对应时间对应类别的销售额
 */
@Data
public class SalesMount {
    private String type;
    private double money;
    private String type_;
    private String time;
}
