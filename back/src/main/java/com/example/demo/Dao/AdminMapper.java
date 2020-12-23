package com.example.demo.Dao;

import com.example.demo.Bean.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AdminMapper {
    /**
     * 验证登录
     * @return
     */
    public Admin judgeLogin(@Param("id") int id, @Param("pwd") int pwd);
}
