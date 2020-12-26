package com.example.demo.Dao.Chart;

import com.example.demo.Bean.DataAnalysis.SalesMount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesMountMapper {
    public int insertSalesMount(SalesMount salesMount);
    public List<SalesMount> querySalesMountByYear(int year);
    public List<SalesMount> querySalesMountAll();
}
