package com.wgh.springcloudtest.userapi.server;


import com.wgh.springcouldtest.commonapi.model.User;

/**
 * Created by wgh on 2021/3/22.
 */
public interface UserService {
    User getById(Integer id);
}
