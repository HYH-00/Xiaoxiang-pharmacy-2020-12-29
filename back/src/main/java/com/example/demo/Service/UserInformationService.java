package com.example.demo.Service;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.Order;
import com.example.demo.Bean.User;
import com.example.demo.Dao.UserInformationDao;
import com.example.demo.Other.MD5;
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
    public boolean verificationUserService(String name,String password) throws Exception {
        password = MD5.md5(password);
        System.out.println(password);
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

    /**
     * 用于用户修改密码
     * @param oldPassword 旧密码
     * @param name 用户名
     * @return 返回是否成功修改
     */
    public boolean userChangeAndVerifyPasswordService(String oldPassword,String name,String newPassword){
        int num = userInformationDao.verificationUser(name,oldPassword);
        if(num==1){
            userInformationDao.changePassword(newPassword, name);
            return true;
        }
        return false;
    }

    /**
     * 订单花费余额扣除服务
     * @param name 用户名
     * @param pay 花费
     * @return 返回是否成功
     */
    public Boolean queryAndChangeBalanceService(String name,double pay){
        double balance = userInformationDao.queryBalance(name);
        if(balance>=pay){
            int a = userInformationDao.changeBalance(name, pay);
            return true;
        }
        return false;
    }

    /**
     * 用户注册
     * @param user
     * @return
     */
    public int addUserService(User user) throws Exception {
        user.setPassword(MD5.md5(user.getPassword()));
        user.setTel(MD5.md5(user.getTel()));
        return userInformationDao.addUser(user);
    }
    public List<User> queryuserbyid(String userid){
        return userInformationDao.queryuserbyid(userid);
    }
    public int rasswordreset(String userid){
        return userInformationDao.rasswordreset(userid);
    }
}
