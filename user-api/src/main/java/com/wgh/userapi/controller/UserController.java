package com.wgh.userapi.controller;

import com.wgh.userapi.bean.User;
import com.wgh.userapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wgh on 2021/3/22.
 */
@RestController
@RequestMapping("/provider/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/get/{id}")
    public User get(@PathVariable("id") Integer id) {
        return this.userService.getById(id);
    }
}
