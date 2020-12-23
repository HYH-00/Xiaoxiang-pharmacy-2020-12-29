package com.example.demo.Dao;

import com.example.demo.Bean.SalesMount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMountMapper {
    public int insertSalesMount(SalesMount salesMount);
    public List<SalesMount> querySalesMountByTime(int time);
}
