package com.example.demo.Controller;

import com.example.demo.Bean.SalesMount;
import com.example.demo.Service.SalesMountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SalesMountController {
    @Autowired
    SalesMountService salesMountService;
    @RequestMapping("insertSalesMount")
    public int insertSalesMount(@RequestBody SalesMount salesMount){
        return salesMountService.insertSalesMount(salesMount);
    }
    @RequestMapping("querySalesMountByTime/{time}")
    public List<SalesMount> querySalesMountByTime(@PathVariable int time){
        return salesMountService.querySalesMountByTime(time);
    }
}
