package com.example.demo.Bean;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.stereotype.Component;

@Data
@Component
@Alias("User")
public class User {
    private String name;
    private String password;
    private double balance;
    private String tel;
    private String sex;
}
