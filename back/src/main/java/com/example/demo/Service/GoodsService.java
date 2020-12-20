package com.example.demo.Service;

import com.example.demo.Bean.Goods;
import com.example.demo.Dao.GoodsDao;
import com.example.demo.Other.AddPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    private AddPath path = AddPath.getInstance();
    /**
     * 促销商品
     * @return 商品
     */
    public List<Goods> findAllDiscountGoodsService(){
        return path.addGoodsImagesPath(goodsDao.findAllDiscountGoods());
    }
    public List<Goods> findGoodsByTypeService(String type){
        return path.addGoodsImagesPath(goodsDao.findGoodsByType(type));
    }
    public List<Goods> findGoodsByTypeService(){
        return path.addGoodsImagesPath(goodsDao.findGoodsByType1());
    }
}
