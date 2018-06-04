package com.cn.frank.test.oauth2.controller;

import com.cn.frank.test.oauth2.domain.User;
import com.cn.frank.test.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: frank_du
 * Time : 2018/5/24 下午1:23
 */
@Controller
@RequestMapping("/oauth2/")
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @RequestMapping("getUser")
    public String getUser(HttpServletRequest request) {
        User user = userService.getUserByUserId("21");
        return "/index";
    }

}
