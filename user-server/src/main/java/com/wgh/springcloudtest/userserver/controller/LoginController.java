package com.wgh.springcloudtest.userserver.controller;

import com.wgh.springcloudtest.commonapi.constant.CommonWords;
import com.wgh.springcloudtest.commonapi.utils.HttpUtils;
import com.wgh.springcloudtest.commonapi.vo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by wgh on 2021/3/30.
 */
@RestController
@RequestMapping("/user")
public class LoginController {

    @PostMapping("/login")
    public Result login(String username, String password, HttpServletResponse response) {
        System.out.println("====================================/user/login");
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        if ("root".equals(username) && "admin".equals(password)) {
            // 模拟生成 token，实际开发中 token 应存放在数据库或缓存中
            String token = "123456";
            Cookie cookie = new Cookie(CommonWords.TOKEN, token);
            cookie.setPath("/");
            cookie.setMaxAge(60* 10 * 10);
            response.addCookie(cookie);
            return Result.success();
        }

        return Result.fail(401, "账号或密码错误");
    }

    @GetMapping("/checkcookie")
    public Result checkCookie(HttpServletRequest request) {
        if (HttpUtils.checkCookie(request, CommonWords.TOKEN, "123456")) {
            return Result.success("cookie正确");
        }
        return Result.fail(Result.FAIL_CODE, "cookie不正确");
    }

}
