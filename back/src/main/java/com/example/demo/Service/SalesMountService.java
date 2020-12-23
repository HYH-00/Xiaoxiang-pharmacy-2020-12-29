package com.example.demo.Service;

import com.example.demo.Bean.SalesMount;
import com.example.demo.Dao.SalesMountMapper;
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
    public List<SalesMount> querySalesMountByTime(int time){
        return salesMountMapper.querySalesMountByTime(time);
    }
}
