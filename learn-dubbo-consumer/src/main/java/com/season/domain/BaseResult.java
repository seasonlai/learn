package com.season.domain;

/**
 * Created by season on 2018/5/8.
 */
public class BaseResult{

    public int code;

    public String msg;

    /**
     * 数据结果集
     */
    public Object data;

    public BaseResult(int code, String msg) {
        this(code, msg, null);
    }

    public BaseResult(BaseResult result) {
        this(result.code, result.msg, result.data);
    }

    public BaseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }


    public static BaseResult unAuthorized(){
        return new BaseResult(678,"权限异常");
    }

    public static BaseResult invalidSession(){
        return new BaseResult(679,"会话已过期");
    }

    public static BaseResult unKnow(String msg){
        return new BaseResult(-1,msg);
    }
}
