package cn.emam.study.common.enums;

/**
 * 基础异常枚举类
 * @author LiQiuShui
 */
public interface BaseErrorInterface {
    /**
     * 获取异常码
     * @return String 返回异常码
     */
    String getResultCode();

    /**
     * 获取异常信息
     * @return String 返回异常信息
     */
    String getResultMsg();
}
