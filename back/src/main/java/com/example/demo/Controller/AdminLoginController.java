package com.example.demo.Controller;

import com.example.demo.Bean.Admin;
import com.example.demo.Bean.Result;
import com.example.demo.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AdminLoginController {
    @Autowired
    AdminService adminService;

    /**
     * 验证登录
     * @return
     */
    @RequestMapping("judgeAdminLogin")
    public Result judgeLogin(@RequestBody Admin admin){
        return Result.ok().put("data",adminService.judgeLogin(admin.getId(),admin.getPwd()));
    }
}
