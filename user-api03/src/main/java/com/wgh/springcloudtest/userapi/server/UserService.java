package com.wgh.userapi.server;

import com.wgh.springcloudtest.userapi.bean.User;

/**
 * Created by wgh on 2021/3/22.
 */
public interface UserService {
    User getById(Integer id);
}