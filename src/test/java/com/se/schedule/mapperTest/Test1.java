package com.se.schedule.mapperTest;

import com.se.schedule.entity.User;
import com.se.schedule.mapper.UserMapper;
import com.se.schedule.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @author: Desmand
 * @time: 2020/11/26 2:58 下午
 */
@SpringBootTest
public class Test1 {
    @Autowired
    private UserService userService;

    @Test
    public void Testlist() {
//        List<User> users = userMapper.selectList(null);
//        System.out.println(users.get(0).getUserName());
    }

    @Test
    public void testSignup() {
        User user = new User();
        user.setUserName("Kongfu102");
        user.setCreateTime(new Date());
        user.setPassword("1234567");
        int code = userService.signUpByUserNameAndPwd(user.getUserName(), user.getPassword());
        System.out.println(code);
    }

    @Test
    public void testUpdate() {
        User user = new User();
        user.setUserName("Kongfu");
        user.setCreateTime(new Date());
        user.setPassword("7");
        String oldPassword = "1234567";
        String pwd = "777";
        System.out.println(userService.update(user.getUserName(), oldPassword, pwd));
    }
    @Test
    public void testUpdateByAdmin() {
        System.out.println(userService.updateByAdmin(13,"123"));

    }

}
