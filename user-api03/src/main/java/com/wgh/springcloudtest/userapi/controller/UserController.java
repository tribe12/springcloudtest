package com.wgh.springcloudtest.userapi.controller;

import com.wgh.springcloudtest.userapi.server.UserService;
import com.wgh.springcouldtest.commonapi.model.User;
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
