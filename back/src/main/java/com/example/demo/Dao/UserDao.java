package com.example.demo.Dao;

import com.example.demo.Bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 把用户的所有订单查询出来
     * @param userId 用户id
     * @return 返回结果集
     */
    public List<Order> findAllOrderByUserId(String userId);

    /**
     * 修改订单配送地址
     * @param userId 用户id
     * @param shopId 商品id
     * @param address 修改地址
     */
    public void modifyAddress(@Param("userId") String userId,
                              @Param("shopId") String shopId,
                              @Param("address") String address,
                              @Param("cancel") String cancel);
}
