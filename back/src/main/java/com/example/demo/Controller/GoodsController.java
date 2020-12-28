package com.example.demo.Controller;

import com.example.demo.Bean.Goods;
import com.example.demo.Bean.Result;
import com.example.demo.Other.AddPath;
import com.example.demo.Service.GoodsService;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    /**
     * 促销打折商品数据接口
     *
     * @return 商品信息
     */
    @RequestMapping("/allDiscountGoods")
    @ResponseBody
    public List<Goods> findAllDiscountGoodsController() {
        List<Goods> list=goodsService.findAllDiscountGoodsService();
//        list= AddPath.getInstance().addGoodsImagesPath(list);
//        for(int i=0;i<list.size();++i){
//            System.out.println(list.get(i).getPicture());
//        }
        return list;
    }

    /**
     * 找到指定属性（type）的商品
     * @param type 类型
     * @return 返回数据
     */
    @RequestMapping("/findGoods")
    @ResponseBody
    public List<Goods> findGoodsByTypeController(@RequestParam("type") String type) {
        if (type.equals("0"))
            return goodsService.findGoodsByTypeService();
        return goodsService.findGoodsByTypeService(type);
    }
    @RequestMapping("/findDetailedGoods")
    @ResponseBody
    public List<Goods> findGoodDetailedByIdController(@RequestParam("id") String shopId){
        return goodsService.findGoodDetailedByIdService(shopId);
    }

    @RequestMapping("/insertGoods")
    @ResponseBody
    public int insertGoods(@RequestBody Goods goods){
//        System.out.println(goods);
        return goodsService.insertGoods(goods);
    }
    @RequestMapping("/findAllGoods")
    @ResponseBody
    public List<Goods> findAllGoods(){
        System.out.println(goodsService.findAllGoods());
        return goodsService.findAllGoods();
    }

    @RequestMapping("findLikeGoodsByName/{name}")
    @ResponseBody
    public List<Goods> findLikeGoodsByName(@PathVariable String name){
        System.out.println(goodsService.findLikeGoodsByName(name));
        return goodsService.findLikeGoodsByName(name);
    }
    @RequestMapping("findLikeGoodsByShopId/{shopId}")
    @ResponseBody
    public List<Goods> findLikeGoodsByShopId(@PathVariable String shopId){
        return goodsService.findLikeGoodsByShopId(shopId);
    }
    @RequestMapping("findLikeGoodsByType/{type}")
    @ResponseBody
    public List<Goods> findLikeGoodsByType(@PathVariable String type){
        return goodsService.findLikeGoodsByType(type);
    }
    @RequestMapping("findLikeGoodsByTrademark/{trademark}")
    @ResponseBody
    public List<Goods> findLikeGoodsByTrademark(@PathVariable String trademark){
        return goodsService.findLikeGoodsByTrademark(trademark);
    }
//    @RequestMapping("/findGoodPictureByShopId/{shopId}")
//    @ResponseBody
//    public Result findGoodPictureByShopId(@PathVariable String shopId){
//        return Result.ok().put("data",goodsService.findGoodPictureByShopId(shopId).get(0));
//    }
 @RequestMapping("deleteGoodPictureByShopId/{shopId}")
 @ResponseBody
 public int deleteGoodPictureByShopId(@PathVariable String shopId){
    return goodsService.deleteGoodPictureByShopId(shopId);
}

    @RequestMapping("updateGoodsByShopId")
    @ResponseBody
    public int updateGoodsByShopId(@RequestBody Goods goods){
//        System.out.println("---");
        return goodsService.updateGoodsByShopId(goods);
    }

}
