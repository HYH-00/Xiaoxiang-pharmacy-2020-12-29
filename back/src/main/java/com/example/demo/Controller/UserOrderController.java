package com.example.demo.Controller;

import com.example.demo.Bean.Order;
import com.example.demo.Service.GoodsService;
import com.example.demo.Service.UserOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class UserOrderController {
    @Autowired
    private UserOrderService userOrderService;

    /**
     * 用于用户订单查询，可以选择全查询也可以进行条件查询
     * @param userid 用户id
     * @param page 页码
     * @param condition 条件
     * @return 返回结果集
     */
    @RequestMapping("/queryOrder")
    @ResponseBody
    public List<Order> findAllOrderByUserId(@RequestParam("userId") String userid,
                                            @RequestParam("page") int page,
                                            @RequestParam("condition") String condition){
        return userOrderService.findAllOrderByUserIdService(userid);
    }

    /**
     * 用于修改配送地址，确认收货以及库存减少接口
     * @param userid 用户id
     * @param address 地址
     * @param shopid 商品id
     * @param cancel 是否收货
     * @param number 减少的库存量
     * @return 返回1
     */
    @RequestMapping("/modifyAddress")
    @ResponseBody
    public int modifyAddressController(@RequestParam("userid") String userid,
                                        @RequestParam("address") String address,
                                        @RequestParam("shopid") String shopid,
                                       @RequestParam("cancel") String cancel,
                                       @RequestParam("number") int number,
                                       @RequestParam("key") int key){
        userOrderService.modifyAddressService(userid, shopid, address,cancel,number,key);
        return 1;
    }

    /**
     * 删除订单
     * @param shopid 商品编号
     * @param userid 用户编号
     * @return 返回结果
     */
    @RequestMapping("/deleteOrder")
    @ResponseBody
    public int deleteOrderController(@RequestParam("shopId") String shopid,
                                     @RequestParam("userId") String userid,
                                     @RequestParam("key") int key){
        userOrderService.deleteOrderService(userid,shopid,key);
        return 1;
    }

    /**
     * 添加多条订单数据
     * @param order 点单数据
     * @return 返回插入条数
     */
    @ResponseBody
    @RequestMapping("/addOrder")
    public int addOrderController(@RequestBody List<Order> order){
        for (Order order1 : order){
            System.out.println(order1.toString());
        }
        return userOrderService.addOrder(order);
    }

    @RequestMapping("/findAllOrder")
    @ResponseBody
    public List<Order> findAllOrder(){
        List<Order> list=userOrderService.findAllOrder();
        return list;
    }
    @RequestMapping("/findLikeOrderByUserId/{userid}")
    @ResponseBody
    public List<Order> findLikeOrderByUserId(@PathVariable String userid){
        return userOrderService.findLikeOrderByUserId(userid);
    }
    @RequestMapping("/findLikeOrderByShopId/{shopId}")
    @ResponseBody
    public List<Order> findLikeOrderByShopId(@PathVariable String shopId){
        return userOrderService.findLikeOrderByShopId(shopId);
    }
    @RequestMapping("/findLikeOrderByCancel/{cancel}")
    @ResponseBody
    public List<Order> findLikeOrderByCancel(@PathVariable String cancel){
        return userOrderService.findLikeOrderByCancel(cancel);
    }
}
