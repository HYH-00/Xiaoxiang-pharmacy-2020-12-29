package com.example.demo.Service.Chart;

import com.example.demo.Bean.DataAnalysis.SalesMount;
import com.example.demo.Bean.DataAnalysis.SalesNum;
import com.example.demo.Dao.Chart.SalesNumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesNumService {
    @Autowired
    SalesNumMapper salesNumMapper;
    public int insertSalesNum(SalesNum salesNum){
        return salesNumMapper.insertSalesNum(salesNum);
    }
    public List<SalesNum> querySalesNumByYear(int year){
        return salesNumMapper.querySalesNumByYear(year);
    }
    public List<SalesNum> querySalesNumAll(){
        return salesNumMapper.querySalesNumAll();
    }
}
