package com.example.demo.Controller.Chart;

import com.example.demo.Bean.Chart.ChartData;
import com.example.demo.Bean.Chart.Num;
import com.example.demo.Bean.DataAnalysis.Drugstype;
import com.example.demo.Bean.Result;
import com.example.demo.Bean.DataAnalysis.SalesNum;
import com.example.demo.Service.Chart.DrugstypeService;
import com.example.demo.Service.Chart.SalesNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class SalesNumController {
    @Autowired
    SalesNumService salesNumService;
    @Autowired
    DrugstypeService drugstypeService;
    @RequestMapping("insertSalesNum")
    public Result insertSalesNum(SalesNum salesNum){
        return Result.ok().put("data",salesNumService.insertSalesNum(salesNum));
    }
    @RequestMapping("querySalesNumByYear/{year}")
    public Result querySalesNumByTime(@PathVariable int year){
        List<SalesNum> list=salesNumService.querySalesNumByYear(year);
        ChartData chartData=new ChartData();
        List<String> columns=new ArrayList<>();
        columns.add("type");
        columns.add("num");
        List rows=new ArrayList<>();

        Map<String,Integer> mp=new HashMap<>();
        List<Drugstype> types=drugstypeService.getAllDrugstype();
        for(int i=0;i<types.size();++i){
            mp.put(types.get(i).getType(),0);
        }
        for(SalesNum sale:list){
            String type=sale.getType();
            Integer value=sale.getNum();
            mp.put(type,mp.get(type)+value);
        }
        Iterator<Map.Entry<String,Integer>> iterator =mp.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> item=iterator.next();
            if(item.getValue()==0)continue;
            Num num=new Num();
            num.setType(item.getKey());
            num.setNum(String.valueOf(item.getValue()));
            rows.add(num);
        }
        chartData.setColumns(columns);
        chartData.setRows(rows);
        return Result.ok().put("data",chartData);

    }
}
