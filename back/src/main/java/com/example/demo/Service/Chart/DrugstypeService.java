package com.example.demo.Service.Chart;

import com.example.demo.Bean.DataAnalysis.Drugstype;
import com.example.demo.Dao.Chart.DrugstypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugstypeService {
    @Autowired
    DrugstypeMapper drugstypeMapper;
    public int insertDrugstype(String type){
        return drugstypeMapper.insertDrugstype(type);
    }
    public List<Drugstype> getAllDrugstype(){
        return drugstypeMapper.getAllDrugstype();
    }
}
