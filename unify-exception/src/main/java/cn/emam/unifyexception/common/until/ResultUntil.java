package cn.emam.unifyexception.common.until;

import cn.emam.unifyexception.common.entity.Result;
import cn.emam.unifyexception.common.enums.BaseErrorInterface;
import cn.emam.unifyexception.common.enums.impl.CommonError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 统一格式工具类
 * @author LiQiuShui
 */
public class ResultUntil {

    private static Logger logger = LoggerFactory.getLogger(ResultUntil.class);

    public static Result success(Object object) {
        Result result = new Result();
        result.setCode(CommonError.SUCCESS.getResultCode());
        result.setMsg(CommonError.SUCCESS.getResultMsg());
        result.setObject(object);
        return result;
    }

    /**
     * 以后如果需要新的特定异常只需继承 BaseErrorInterface 即可
     * @param errorInterface
     * @return Result
     */
    public static Result error(BaseErrorInterface errorInterface) {
        Result result = new Result();
        result.setCode(errorInterface.getResultCode());
        result.setMsg(errorInterface.getResultMsg());
        result.setObject(null);
        return result;
    }

    public static Result error(String code, String msg) {
        logger.error("222, error");
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setObject(null);
        return result;
    }

    public static Result error(String msg) {
        Result result = new Result();
        result.setCode(CommonError.ERROR.getResultCode());
        result.setMsg(msg);
        result.setObject(null);
        return result;
    }
}
