package com.example.demo.Controller;

import com.example.demo.Bean.Order;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashSet;
import java.util.List;

@Controller
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

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
        return userService.findAllOrderByUserIdService(userid);
    }

    @RequestMapping("/modifyAddress")
    @ResponseBody
    public int modifyAddressController(@RequestParam("userid") String userid,
                                        @RequestParam("address") String address,
                                        @RequestParam("shopid") String shopid,
                                       @RequestParam("cancel") String cancel){
        userService.modifyAddressService(userid, shopid, address,cancel);
        return 1;
    }
}
