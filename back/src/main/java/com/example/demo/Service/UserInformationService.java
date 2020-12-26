package com.example.demo.Service;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.Order;
import com.example.demo.Dao.UserInformationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.SocketHandler;

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

    /**
     *用户订单类型金额分析
     */
    public List<GoodsTypeNumber> userDataAnalysisService(String userid){
        List<GoodsTypeNumber> list = userInformationDao.GoodsTypeDataAnalysis(userid);
        return list;
    }

    /**
     * 用户余额查询
     * @param userid 用户id
     * @return 返回余额
     */
    public double userBalanceService(String userid){
        return userInformationDao.userBalance(userid);
    }
}
