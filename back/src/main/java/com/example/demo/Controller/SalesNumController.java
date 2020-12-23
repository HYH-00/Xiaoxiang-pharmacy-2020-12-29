package com.example.demo.Controller;

import com.example.demo.Bean.SalesNum;
import com.example.demo.Service.SalesNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class SalesNumController {
    @Autowired
    SalesNumService salesNumService;
    @RequestMapping("insertSalesNum")
    public int insertSalesNum(SalesNum salesNum){
        return salesNumService.insertSalesNum(salesNum);
    }
    @RequestMapping("querySalesNumByTime/{time}")
    public List<SalesNum> querySalesNumByTime(@PathVariable int time){
        return salesNumService.querySalesNumByTime(time);

    }
}
