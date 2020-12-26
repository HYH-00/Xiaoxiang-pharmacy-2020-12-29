package com.example.demo.Controller.Chart;

import com.example.demo.Bean.Chart.*;
import com.example.demo.Bean.DataAnalysis.Drugstype;
import com.example.demo.Bean.DataAnalysis.SalesNum;
import com.example.demo.Bean.Result;
import com.example.demo.Bean.DataAnalysis.SalesMount;
import com.example.demo.Service.Chart.DrugstypeService;
import com.example.demo.Service.Chart.SalesMountService;
import com.example.demo.Service.Chart.SalesNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin
public class SalesController {
    @Autowired
    SalesMountService salesMountService;
    @Autowired
    SalesNumService salesNumService;
    @Autowired
    DrugstypeService drugstypeService;

    @RequestMapping("insertSalesMount")
    public Result insertSalesMount(@RequestBody SalesMount salesMount){
        return Result.ok().put("data",salesMountService.insertSalesMount(salesMount));
    }
    @RequestMapping("querySalesMountByYear/{year}")
    public Result querySalesMountByTime(@PathVariable int year){
        List<SalesMount> list=salesMountService.querySalesMountByYear(year);
        ChartData chartData1 =new ChartData();
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
        chartData1.setColumns(columns);
        chartData1.setRows(rows);
        return Result.ok().put("data", chartData1);
    }
    @RequestMapping("insertSalesNum")
    public Result insertSalesNum(SalesNum salesNum){
        return Result.ok().put("data",salesNumService.insertSalesNum(salesNum));
    }
    @RequestMapping("querySalesNumByYear/{year}")
    public Result querySalesNumByTime(@PathVariable int year){
        List<SalesNum> list=salesNumService.querySalesNumByYear(year);
        ChartData chartData1 =new ChartData();
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
        chartData1.setColumns(columns);
        chartData1.setRows(rows);
        return Result.ok().put("data", chartData1);
    }
    @RequestMapping("queryOrderTime")
    public Result queryOrderTime(){
        ChartData chartData =new ChartData();
        Calendar cal = Calendar.getInstance();
        int year=cal.get(Calendar.YEAR);
        List<SalesNum> listnum=salesNumService.querySalesNumAll();
        List<SalesMount> listmount=salesMountService.querySalesMountAll();

        List<String> columns=new ArrayList<>();
        List<RowData> rows=new ArrayList<>();
        columns.add("date");
        columns.add("mount");
        columns.add("num");

        double w[][][]=new double[year+5][15][2];

        int l=2019,r=year;
        for(int i=l;i<=r;++i)for(int j=1;j<=12;++j)w[i][j][0]=w[i][j][1]=0;

        for(int i=0;i<listmount.size();++i){
            SalesMount salesMount=listmount.get(i);
            int a=Integer.parseInt(salesMount.getYear());
            int b=Integer.parseInt(salesMount.getMonth());
            w[a][b][0]+=salesMount.getMoney();
        }
        for(int i=0;i<listnum.size();++i){
            SalesNum salesNum=listnum.get(i);
            int a=Integer.parseInt(salesNum.getYear());
            int b=Integer.parseInt(salesNum.getMonth());
            w[a][b][1]+=salesNum.getNum();
        }
        for(int i=l;i<=r;++i){
            for(int j=1;j<=12;++j){
                OrderTime orderTime=new OrderTime();
                String date=String.valueOf(i)+"-"+String.valueOf(j);
                orderTime.setDate(date);
                orderTime.setMount(String.valueOf(w[i][j][0]));
                orderTime.setNum(String.valueOf(w[i][j][1]));
                rows.add(orderTime);
            }
        }
        chartData.setColumns(columns);
        chartData.setRows(rows);
        System.out.println(chartData);
        return Result.ok().put("data", chartData);
    }
}