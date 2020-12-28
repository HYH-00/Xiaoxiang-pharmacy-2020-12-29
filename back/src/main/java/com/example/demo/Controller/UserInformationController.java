package com.example.demo.Controller;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.Result;
import com.example.demo.Bean.User;
import com.example.demo.Dao.UserInformationDao;
import com.example.demo.Service.UserInformationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@CrossOrigin
public class UserInformationController {
    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private UserInformationDao userInformationDao;
    /**
     * 验证用户身份
     * @param user 用户信息
     * @return 返回结果
     */
    @RequestMapping("/verification")
    @ResponseBody
    public Map<String,Boolean> verificationUserController(@RequestBody User user) throws Exception {
        boolean flag = userInformationService.verificationUserService(user.getName(),user.getPassword());
        Map<String,Boolean> map = new HashMap<>();
        map.put("flag",flag);
        return map;
    }

    /**
     * 用户金额数据分析数据
     * @param userid 用户id
     * @return 返回数据分析结果集
     */
    @ResponseBody
    @RequestMapping("/userDataAnalysis")
    public List<GoodsTypeNumber> userDataAnalysis(@RequestParam("userid") String userid){
        return userInformationService.userDataAnalysisService(userid);
    }

    /**
     * 用户余额
     * @param userid 用户id
     * @return 返回余额
     */
    @ResponseBody
    @RequestMapping("/userBalance")
    public double userBalanceController(@RequestParam("userid") String userid){
        return userInformationService.userBalanceService(userid);
    }

    /**
     * 修改用户密码
     * @param name 用户名
     * @param password 需要修改的密码
     * @return 返回是否修改成功
     */
    @ResponseBody
    @RequestMapping("/changePassword")
    public Boolean verifyAndChangPasswordController(@RequestParam("userid") String name,
                                                    @RequestParam("password") String password,
                                                    @RequestParam("newPassword") String newPassword){
        return userInformationService.userChangeAndVerifyPasswordService(password,name,newPassword);
    }

    /**
     * 订单尾款支付
     * @param name 用户名
     * @param pay 花费
     * @return 是否符合
     */
    @ResponseBody
    @RequestMapping("/pay")
    public Boolean queryAndChangeBalanceController(@RequestParam("name") String name,
                                                   @RequestParam("pay") double pay){
        return userInformationService.queryAndChangeBalanceService(name, pay);
    }

    /**
     * 查询余额
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/balance")
    public double queryBalanceController(@RequestParam("name") String name){
        return userInformationDao.queryBalance(name);
    }

    @ResponseBody
    @RequestMapping("/adduser")
    public int addUserController(@RequestBody User user) throws Exception {
        return userInformationService.addUserService(user);
    }
    @ResponseBody
    @RequestMapping("/queryuserbyid/{userid}")
    public Result queryuserbyid(@PathVariable String userid){
        System.out.println(userInformationService.queryuserbyid(userid).get(0).toString());
        return Result.ok().put("data",userInformationService.queryuserbyid(userid).get(0));
    }
    @ResponseBody
    @RequestMapping("/rasswordreset/{userid}")
    public String rasswordreset(@PathVariable String userid){
        System.out.println("----"+userid);
        int x=userInformationService.rasswordreset(userid);
        System.out.println(x);
        if(x>0)return "成功";
        return "失败";
    }

}
