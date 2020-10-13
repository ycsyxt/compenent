package cn.com.chnsys.pageplugin.controller;

import cn.com.chnsys.pageplugin.entity.User;
import cn.com.chnsys.pageplugin.service.IUserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * @author yuxt
 **/
@Controller
@RequestMapping("/system/user")
public class UserController
{
    @Autowired
    IUserService userService;
    @GetMapping()
    public String listAllUser(String ids){
        User user = new User();
        user.setUserType("00");
        PageHelper.startPage(1, 2);
        List<User> users = userService.selectUserList(user);
        Long total = PageHelper.count(()->userService.selectUserList(user));
        return "list";
    }
}
