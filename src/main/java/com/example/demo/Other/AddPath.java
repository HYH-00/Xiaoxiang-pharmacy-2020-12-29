package com.example.demo.Other;

import com.example.demo.Bean.Goods;

import java.util.List;

public class AddPath {
    /**
     * 可以改变图片存放的位置
     * 数据库仅仅需要存放图片名称
     * @param goodsList 需要修改的数据
     * @return 返回修改的数据
     */
    public static List<Goods> addGoodsImagesPath(List<Goods> goodsList){
       for(int i=0;i<goodsList.size();i++){
           goodsList.get(i).setPicture("http://localhost:8080/shop/goodsImages/"+goodsList.get(i).getPicture());
       }
        return goodsList;
    }
}
