package com.example.cuteu.utils;

/**
 * @author shachi
 */
public class TotalResult<T> {
    private Integer status;
    private String msg;
    private T data;

    public TotalResult() {

    }

    public TotalResult(Integer status, String msg, T data) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public TotalResult(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public TotalResult(Integer status, T data) {
        this.status = status;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public TotalResult<T> setStatus(Integer status) {
        this.status = status;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public TotalResult<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public TotalResult<T> setData(T data) {
        this.data = data;
        return this;
    }

}
