package com.example.demo.Dao;

import com.example.demo.Bean.SalesNum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesNumMapper {
    public int insertSalesNum(SalesNum salesNum);
    public List<SalesNum> querySalesNumByTime(int time);
}
