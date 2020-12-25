package com.example.demo.Dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
}
