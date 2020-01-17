package cn.emam.unifyexception.common.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 统一返回值实体
 * @author LiQiuShui
 */
@Setter
@Getter
public class Result {
    private String code;
    private String msg;
    private Object object;
}
