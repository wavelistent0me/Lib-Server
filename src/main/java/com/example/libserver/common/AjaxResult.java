package com.example.libserver.common;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

//统一返回
@Data
public class AjaxResult {
    public static final Integer CODE_SUCCESS = 200;
    public static final Integer CODE_ERROR = 500;

    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    //构造方法私有化,在其他地方不能new R()这样创建变量
    private AjaxResult() {}
    private AjaxResult(Integer code, String message, Map<String, Object> data) {
        this.setCode(code);
        this.setMessage(message);
        this.setData(data);
    }

    //不带data的返回
    public static AjaxResult Success() {
        return new AjaxResult(CODE_SUCCESS, "成功", null);
    }
    //自定义data
    public static AjaxResult Success(Map<String, Object> data) {
        return new AjaxResult(CODE_SUCCESS, "成功", data);
    }
    //自定义data code
    public static AjaxResult Success(Integer code, Map<String, Object> data) {
        return new AjaxResult(code, "成功", data);
    }
    //自定义data message code
    public static AjaxResult Success(Integer code, String message, Map<String, Object> data) {
        return new AjaxResult(code, message, data);
    }

    public static AjaxResult Error() {
        return new AjaxResult(CODE_ERROR, "错误", null);
    }
}
