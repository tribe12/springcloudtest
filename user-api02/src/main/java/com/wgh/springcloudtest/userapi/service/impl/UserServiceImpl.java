package com.wgh.springcloudtest.userapi.service.impl;

import com.wgh.springcloudtest.userapi.service.UserService;
import com.wgh.springcloudtest.commonapi.model.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wgh on 2021/3/22.
 */
@Service
public class UserServiceImpl implements UserService {

    private static Map<Integer, User> map;

    static {
        map = new HashMap<>();
        for (int i = 1; i < 6; i++) {
            map.put(i, new User(i, "test02_" + i, "pwd02_" + i));
        }
    }

    @Override
    public User getById(Integer id) {
        return map.get(id);
    }

}
