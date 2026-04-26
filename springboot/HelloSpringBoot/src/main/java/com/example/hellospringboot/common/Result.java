package com.example.hellospringboot.common;

public class Result<T> {
    private int code;
    private String message;
    private T data;

    public Result(){}
    public Result(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //成功
    public static <T> Result<T> success(T data){
        return new Result<T>(200,"success",data);
    }
    //失败
    public static <T> Result<T> error(String message){
        return new Result<T>(500,message,null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
