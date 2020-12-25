package com.example.demo.Controller.Chart;

import com.example.demo.Bean.Chart.ChartData;
import com.example.demo.Bean.Chart.Mount;
import com.example.demo.Bean.DataAnalysis.Drugstype;
import com.example.demo.Bean.Result;
import com.example.demo.Bean.DataAnalysis.SalesMount;
import com.example.demo.Service.Chart.DrugstypeService;
import com.example.demo.Service.Chart.SalesMountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class SalesMountController {
    @Autowired
    SalesMountService salesMountService;
    @Autowired
    DrugstypeService drugstypeService;
    @RequestMapping("insertSalesMount")
    public Result insertSalesMount(@RequestBody SalesMount salesMount){
        return Result.ok().put("data",salesMountService.insertSalesMount(salesMount));
    }
    @RequestMapping("querySalesMountByYear/{year}")
    public Result querySalesMountByTime(@PathVariable int year){
        List<SalesMount> list=salesMountService.querySalesMountByYear(year);
        ChartData chartData=new ChartData();
        List<String> columns=new ArrayList<>();
        columns.add("type");
        columns.add("money");
        List rows=new ArrayList<>();

        Map<String,Double> mp=new HashMap<>();
        List<Drugstype> types=drugstypeService.getAllDrugstype();
        for(int i=0;i<types.size();++i){
            mp.put(types.get(i).getType(),0.0);
        }
        for(SalesMount sale:list){
            String type=sale.getType();
            Double value=sale.getMoney();
            mp.put(type,mp.get(type)+value);
        }
        Iterator<Map.Entry<String,Double>> iterator =mp.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Double> item=iterator.next();
            if(item.getValue()==0)continue;
            Mount num=new Mount();
            num.setType(item.getKey());
            num.setMoney(String.valueOf(item.getValue()));
            rows.add(num);
        }
        chartData.setColumns(columns);
        chartData.setRows(rows);
        return Result.ok().put("data",chartData);
    }
}