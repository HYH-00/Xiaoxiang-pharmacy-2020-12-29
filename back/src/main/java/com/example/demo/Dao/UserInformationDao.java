package com.example.demo.Dao;

import com.example.demo.Bean.GoodsTypeNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserInformationDao {
    /**
     * 用户身份验证
     * @param name 用户名
     * @param password 密码
     * @return 返回数据个数
     */
    @Select("select count(*) from user where name = #{name} and password = #{password}")
    public int verificationUser(@Param("name") String name,@Param("password") String password);

    /**
     * 用户订单类型金额数据分析
     * @param userid 用户id
     * @return 返回数据集
     */
    @Select("select goods.type as type,COUNT(*) as number,SUM(order1.allprice) as amount,SUM(order1.discount) as discount from order1,goods where order1.userid = #{userid} and order1.shopid = goods.shopid GROUP BY goods.type ;")
    public List<GoodsTypeNumber> GoodsTypeDataAnalysis(String userid);

    /**
     * 用户余额查询
     * @param userid 用户id
     * @return 返回余额
     */
    @Select("select balance from user where name = #{userid}")
    public double userBalance(String userid);
}
