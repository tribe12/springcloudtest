package com.wgh.springcouldtest.commonapi.vo;

/**
 * Created by wgh on 2021/3/26.
 */

import lombok.Getter;

import java.io.Serializable;

@Getter
public class Result implements Serializable {
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;

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
        return new Result(SUCCESS_CODE, "success", data);
    }

    public static Result fail() {
        return fail(FAIL_CODE, "fail");
    }

    public static Result fail(int code, String message) {
        return new Result(code, message);
    }
}

