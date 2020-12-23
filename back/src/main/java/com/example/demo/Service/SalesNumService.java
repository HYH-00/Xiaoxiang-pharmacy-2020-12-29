package com.example.demo.Service;

import com.example.demo.Bean.SalesMount;
import com.example.demo.Bean.SalesNum;
import com.example.demo.Dao.SalesMountMapper;
import com.example.demo.Dao.SalesNumMapper;
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
    public List<SalesNum> querySalesNumByTime(int time){
        return salesNumMapper.querySalesNumByTime(time);
    }
}
