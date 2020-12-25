package com.example.demo.Service;

import com.example.demo.Dao.UserInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInformationService {
    @Autowired
    private UserInformationDao userInformationDao;

    /**
     * 验证用户身份
     * @param name 用户名
     * @param password 密码
     * @return 返回数据
     */
    public boolean verificationUserService(String name,String password){
        int num = userInformationDao.verificationUser(name, password);
        if(num==1)
            return true;
        return false;
    }
}
