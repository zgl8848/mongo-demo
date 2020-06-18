package com.cmd.mongodemo.entity.util;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Date;
import java.util.List;


public class JsonUtil<T> {

    private Integer code;

    private String msg;

    private List<T> data;

    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
