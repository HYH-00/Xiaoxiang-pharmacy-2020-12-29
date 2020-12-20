package com.example.demo.Controller;

import com.example.demo.Bean.Goods;
import com.example.demo.Service.GoodsService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 促销打折商品数据接口
     * @return 商品信息
     */
    @RequestMapping("/allDiscountGoods")
    @ResponseBody
    public List<Goods> findAllDiscountGoodsController(){
        return goodsService.findAllDiscountGoodsService();
    }
}
