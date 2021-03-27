package com.wgh.springcouldtest.commonapi.vo;

/**
 * Created by wgh on 2021/3/26.
 */

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Result implements Serializable {


    private int code;

    private String msg;

    private Object data;

    private Result() {
    }

    private Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static Result success() {
        return success(null);
    }

    public static Result success(Object data) {
        return new Result(200, "success", data);
    }

    public static Result fail() {
        return fail(500, "fail");
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }
}

