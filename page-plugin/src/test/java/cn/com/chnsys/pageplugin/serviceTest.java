package cn.com.chnsys.pageplugin;

import cn.com.chnsys.pageplugin.entity.User;
import cn.com.chnsys.pageplugin.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.UUID;

/**
 * 测试service的基本功能
 * insertUser,selectUserById,selectUserList,updateUser,deleteUserByIds,deleteUserById
 * @author yuxt
 **/
@SpringBootTest
public class serviceTest {
    @Autowired
    IUserService iUserService;

    @Test
    void insertUserTest(){
        User user = new User();
        user.setUserId(Long.parseLong("2220164118"));
        user.setUserName("yuxt");
        user.setPassword("123456");
        String uuid = UUID.randomUUID().toString().substring(0,10);
        user.setSalt(uuid+user.getPassword());
        user.setLoginName("yuxt");
        iUserService.insertUser(user);
    }
    @Test
    void selectUserByIdTest(){
        User user = iUserService.selectUserById(Long.parseLong("3"));
        Assert.isTrue(user != null,"没有查询到用户");
    }
}
