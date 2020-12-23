package com.example.demo.Service;

import com.example.demo.Bean.Goods;
import com.example.demo.Bean.Order;
import com.example.demo.Dao.UserDao;
import com.example.demo.Other.AddPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    private AddPath path = AddPath.getInstance();

    /**
     * 查询用户的所用订单
     * @param userId 用户id
     * @return 返回结果集
     */
    public List<Order> findAllOrderByUserIdService(String userId){
        List<Order> orders = userDao.findAllOrderByUserId(userId);
        System.out.println(orders.size());
        List<Goods> goods = new LinkedList<>();
        for(int i=0;i<orders.size();i++){
            goods.add(orders.get(i).getGoods());
        }
        path.addGoodsImagesPath(goods);
        for(int i=0;i<orders.size();i++){
            orders.get(i).setGoods(goods.get(i));
            System.out.println(orders.get(i).toString());
        }
        System.out.println(orders.size());
        return orders;
    }
    /**
     * 修改订单配送地址
     * @param userId 用户id
     * @param shopId 商品id
     * @param address 修改地址
     */
    public void modifyAddressService(String userId,String shopId,String address,String cancel){
        userDao.modifyAddress(userId, shopId, address,cancel);
    }
}
