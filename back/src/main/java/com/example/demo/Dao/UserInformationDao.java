package com.example.demo.Dao;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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

    /**
     * 修改密码
     * @param oldPassword 旧密码
     * @param name 用户名
     */
    @Update("update user set password = #{password} where name = #{name}")
    public void changePassword(@Param("password") String oldPassword,@Param("name") String name);

    /**
     * 余额查询
     * @param name 用户名
     * @return 返回余额
     */
    @Select("select balance from user where name = #{name}")
    public double queryBalance(String name);

    /**
     * 修改余额
     * @param name 用户名
     * @param pay 花费
     * @return 返回修改列
     */
    @Update("update user set balance = balance-#{pay} where name = #{name}")
    public int changeBalance(@Param("name") String name,@Param("pay") double pay);

    /**
     *
     */
    @Insert("insert into user values(#{name},#{password},#{balance},#{tel})")
    public int addUser(User user);

    @Update("update user set password='e10adc3949ba59abbe56e057f20f883e' where id= #{userid}")
    public int rasswordreset(String userid);

    @Select("select * from user where name=#{userid}")
    public List<User> queryuserbyid(String userid);
}
