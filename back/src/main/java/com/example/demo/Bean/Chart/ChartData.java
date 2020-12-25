package com.example.demo.Bean.Chart;

import lombok.Data;

import java.util.List;

@Data
public class ChartData {
    private List<String> columns;
    private List<RowData> rows;
}
