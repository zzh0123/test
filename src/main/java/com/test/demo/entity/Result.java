package com.test.demo.entity;

import java.io.Serializable;

/**
 * @author zzh
 * @create 2019-08-18 22:01
 * @desc 请求结果
 */
public class Result implements Serializable {

    private Object data;
    private String message;
    private int code; // 成功 200， 否则失败

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
