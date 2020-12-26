package com.example.demo.Dao.Chart;

import com.example.demo.Bean.DataAnalysis.Drugstype;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugstypeMapper {
    public int insertDrugstype(String type);
    public List<Drugstype> getAllDrugstype();
}
