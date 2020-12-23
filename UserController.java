package com.example.demo.Controller;

import com.example.demo.Bean.User;
import com.example.demo.Dao.UserDao;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public class UserController {
    @Autowired
    private UserService userService;
    private UserDao userDao;

    /**
     *
     *
     */
    @GetMapping("/greeting")
    public String siginForm(Model model){
        model.addAttribute("user",new User());
        return "sigin";
    }

    @PostMapping("/greeting")
    public String siginSubmit(@ModelAttribute User user) {
        User newUser=new User();

        newUser.setId(user.getId());
        newUser.setPassword(user.getPassword());
        newUser.setBalance(user.getBalance());
        newUser.setTel(user.getTel());
        newUser.setCarid(user.getCarid());
        newUser.setMail(user.getMail());
        newUser.setQq(user.getQq());
        userDao.save(user);

        return "result";
    }

    @GetMapping("/all")
    public String getMessage(Model model){
        Iterable<User> users=userDao.findAll();
        model.addAttribute("users",users);
        return "all";
    }
}
