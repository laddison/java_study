package cn.emam.study.common.enums.impl;

import cn.emam.study.common.enums.BaseErrorInterface;

/**
 * 异常枚举实体类
 * @author LiQiuShui
 */
public enum CommonError implements BaseErrorInterface{
    // 数据操作错误定义
    SUCCESS("200", "成功"),
    ERROR("-1", "失败"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!");

    private String code;
    private String msg;

    CommonError(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getResultCode() {
        return code;
    }

    @Override
    public String getResultMsg() {
        return msg;
    }
}
