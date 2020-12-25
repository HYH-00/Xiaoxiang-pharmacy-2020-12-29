package com.example.demo.Controller;

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
import java.util.Map;

@Controller
public class UserInformationController {
    @Autowired
    private UserInformationService userInformationService;

    @RequestMapping("/verification")
    @ResponseBody
    public Map<String,Boolean> verificationUserController(@RequestBody User user){
        boolean flag = userInformationService.verificationUserService(user.getName(),user.getPassword());
        Map<String,Boolean> map = new HashMap<>();
        map.put("flag",flag);
        return map;
    }
}
