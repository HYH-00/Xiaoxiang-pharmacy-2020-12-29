package com.example.demo.Bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.stereotype.Component;

@Alias("GoodsDetailed")
@Data
@Component
public class GoodsDetailed {
//    商品Id
    private String shopId;
//    执行标准
    private String ExecutiveStandard;
//    性状
    private String Traits;
//    作用类别
    private String FunctionCategory;
//    药理毒理
    private String PharmacologyAndToxicology;
//    适应症
    private String Indications;
//    用法用量
    private String Dosage;
//    不良反应
    private String AdverseReactions;
//    禁忌症
    private String Contraindications;
//    药物相互作用
    private String medicineInteractions;
//    贮藏
    private String Store;
}
