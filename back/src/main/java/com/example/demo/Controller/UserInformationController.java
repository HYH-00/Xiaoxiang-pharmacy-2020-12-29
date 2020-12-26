package com.example.demo.Controller;

import com.example.demo.Bean.GoodsTypeNumber;
import com.example.demo.Bean.User;
import com.example.demo.Service.UserInformationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserInformationController {
    @Autowired
    private UserInformationService userInformationService;

    /**
     * 验证用户身份
     * @param user 用户信息
     * @return 返回结果
     */
    @RequestMapping("/verification")
    @ResponseBody
    public Map<String,Boolean> verificationUserController(@RequestBody User user){
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
    public double userBalanceController(@RequestParam("userid") String userid){
        return userInformationService.userBalanceService(userid);
    }
}
