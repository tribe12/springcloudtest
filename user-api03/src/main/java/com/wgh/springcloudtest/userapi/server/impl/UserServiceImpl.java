package com.wgh.userapi.server.impl;

import com.wgh.userapi.server.UserService;
import com.wgh.springcloudtest.userapi.bean.User;
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
            map.put(i, new User(i, "test03_" + i, "pwd03_" + i));
        }
    }

    @Override
    public User getById(Integer id) {
        return map.get(id);
    }

}
