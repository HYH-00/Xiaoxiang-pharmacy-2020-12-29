package com.example.demo.Bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Alias("User")
@Data
@Component
public class User {
    //  用户名
    private String id;
    //  密码
    private String password;
    //  余额
    private double balance;
    //  手机号
    private String tel;
    //  身份证号
    private String carid;
    //  mail
    private String mail;
    //  qq
    private String qq;



}
