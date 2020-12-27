package com.example.demo.Dao;

import com.example.demo.Bean.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserOrderDao {
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

    /**
     * 通过用户与商品编号，在确认收货以后减少库存量
     * @param shopId 商品编号
     * @param number 减少的库存量
     */
    public void ModifyInventory(@Param("shopId") String shopId,
                                @Param("number") int number);

    /**
     * 删除用户订单
     * @param shopId 商品编号
     * @param userId 用户编号
     */
    public void deleteOrder(@Param("shopId") String shopId,
                            @Param("userId") String userId);

    public List<Order> findAllOrder();
    public List<Order> findLikeOrderByUserId(String userid);
    public List<Order> findLikeOrderByShopId(String shopId);
    public List<Order> findLikeOrderByCancel(String cancel);
}
