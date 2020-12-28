package com.example.demo.Dao;


import com.example.demo.Bean.Goods;
import com.example.demo.Bean.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 用于找到所有打折促销的商品----多表联合查询
     * @return 返回查询的结果
     */
    public List<Goods> findAllDiscountGoods();
    /**
     * 查询指定的商品
     */
    public List<Goods> findGoodsByType(String type);
    public List<Goods> findGoodsByType1();

    /**
     * 用于查询指定id的商品详细信息
     * @param shopId  商品id
     * @return 返回数据的
     */
    public List<Goods> findGoodDetailedById(String shopId);

    public int insertGoods(Goods goods);

    public List<Goods> findAllGoods();


    public List<Goods> findLikeGoodsByName(String name);
    public List<Goods> findLikeGoodsByShopId(String shopId);
    public List<Goods> findLikeGoodsByType(String type);
    public List<Goods> findLikeGoodsByTrademark(String trademark);

    public List<Goods> findGoodPictureByShopId(String shopId);

    public int deleteGoodPictureByShopId(String shopId);

    public int updateGoodsByShopId(Goods goods);
}
