package com.example.demo.Bean;

import lombok.Data;
import lombok.ToString;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 用于保存商品的属性类
 */
@Alias("Goods")
@Data
@Component
public class Goods {
//    批准文号--唯一标识符
    private String shopId;
//    价格
    private double price;
//    商品名称
    private String name;
//    描述
    private String description;
//    物品图片
    private String picture;
//    库存量
    private int number;
//    商标
    private String trademark;
//    有效期
    private String validPeriod;
//    包装规格
    private String packingSpecification;
//    制造商
    private String manufacturer;
//    折扣
    private double discount;
//    折扣过期时间
    private Date time;

    @Override
    public String toString() {
        return "Goods{" +
                "shopId='" + shopId + '\'' +
                ", price=" + price +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", number=" + number +
                ", tradeMake='" + trademark + '\'' +
                ", validPeriod='" + validPeriod + '\'' +
                ", packingSpecification='" + packingSpecification + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", discount=" + discount +
                ", time=" + time +
                '}';
    }
}
