package com.callor.attch.model;

public class chatt {

    private String name;

    @Override
    public String toString() {
        return "chatt{" +
                "name='" + name + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }

    private String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
