package com.example.demo.Service;

import com.example.demo.Bean.Goods;
import com.example.demo.Bean.Order;
import com.example.demo.Dao.UserOrderDao;
import com.example.demo.Other.AddPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UserOrderService {
    @Autowired
    private UserOrderDao userOrderDao;
    private AddPath path = AddPath.getInstance();

    /**
     * 查询用户的所用订单
     * @param userId 用户id
     * @return 返回结果集
     */
    public List<Order> findAllOrderByUserIdService(String userId){
        List<Order> orders = userOrderDao.findAllOrderByUserId(userId);
        List<Goods> goods = new LinkedList<>();
        for(int i=0;i<orders.size();i++){
            goods.add(orders.get(i).getGoods());
        }
        path.addGoodsImagesPath(goods);
        for(int i=0;i<orders.size();i++){
            orders.get(i).setGoods(goods.get(i));
        }
        return orders;
    }
    /**
     * 修改订单配送地址  《《外观模式》》
     * @param userId 用户id
     * @param shopId 商品id
     * @param address 修改地址
     * @param cancel 是否确认到货
     */
    public void modifyAddressService(String userId,String shopId,String address,String cancel,int number){
        userOrderDao.modifyAddress(userId, shopId, address,cancel);
        if(!cancel.equals("air"))
            userOrderDao.ModifyInventory(shopId, number);
    }

    /**
     * 删除订单
     * @param userId 用户编号
     * @param shopId 商品编号
     */
    public void deleteOrderService(String userId,String shopId){
        userOrderDao.deleteOrder(shopId,userId);
    }
}
