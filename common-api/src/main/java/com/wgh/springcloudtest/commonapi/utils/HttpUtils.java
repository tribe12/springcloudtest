package com.wgh.springcloudtest.commonapi.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by wgh on 2021/3/31.
 */
public class HttpUtils {


    /**
     * 校验cookie
     *
     * @param request
     * @param cookieName
     * @param cookieValue
     * @return
     */
    public static boolean checkCookie(HttpServletRequest request, String cookieName, String cookieValue) {
        System.out.println("----- HttpUtils checkCookie -----");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookieName != null && cookieValue != null) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName()) && cookieValue.equals(cookie.getValue())) {
                    System.out.println("----- HttpUtils checkCookie 验证通过 -----");
                    return true;
                }
            }
        }
        return false;
    }
}
