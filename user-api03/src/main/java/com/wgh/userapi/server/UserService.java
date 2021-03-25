package com.wgh.userapi.service;

import com.wgh.userapi.bean.User;

/**
 * Created by wgh on 2021/3/22.
 */
public interface UserService {
    User getById(Integer id);
}
