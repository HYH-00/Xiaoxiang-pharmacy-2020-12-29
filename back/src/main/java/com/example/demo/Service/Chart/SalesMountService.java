package com.example.demo.Service.Chart;

import com.example.demo.Bean.DataAnalysis.SalesMount;
import com.example.demo.Dao.Chart.SalesMountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesMountService {
    @Autowired
    SalesMountMapper salesMountMapper;
    public int insertSalesMount(SalesMount salesMount){
        return salesMountMapper.insertSalesMount(salesMount);
    }
    public List<SalesMount> querySalesMountByYear(int year){
        return salesMountMapper.querySalesMountByYear(year);
    }
    public List<SalesMount> querySalesMountAll(){
        return salesMountMapper.querySalesMountAll();
    }
}
