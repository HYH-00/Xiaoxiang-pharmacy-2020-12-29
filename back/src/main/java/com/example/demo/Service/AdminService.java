package com.example.demo.Service;

import com.example.demo.Bean.Admin;
import com.example.demo.Dao.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminMapper adminMapper;

    /**
     * 验证登录
     * @param id
     * @param pwd
     * @return
     */
    public Admin judgeLogin(int id, int pwd){
        return adminMapper.judgeLogin(id,pwd);
    }
}
