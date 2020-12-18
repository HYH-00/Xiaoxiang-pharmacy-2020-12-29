package com.example.demo.Dao;


import com.example.demo.Bean.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 用于找到所有打折促销的商品----多表联合查询
     * @return 返回查询的结果
     */
    public List<Goods> findAllDiscountGoods();
}
