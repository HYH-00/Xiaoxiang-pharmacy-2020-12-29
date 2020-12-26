package com.example.demo.Dao.Chart;

import com.example.demo.Bean.DataAnalysis.SalesMount;
import com.example.demo.Bean.DataAnalysis.SalesNum;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalesNumMapper {
    public int insertSalesNum(SalesNum salesNum);
    public List<SalesNum> querySalesNumByYear(int year);
    public List<SalesNum> querySalesNumAll();
}
