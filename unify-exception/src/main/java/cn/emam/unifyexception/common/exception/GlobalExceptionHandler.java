package cn.emam.unifyexception.common.exception;

import cn.emam.unifyexception.common.entity.Result;
import cn.emam.unifyexception.common.enums.impl.CommonError;
import cn.emam.unifyexception.common.handle.ExceptionHandle;
import cn.emam.unifyexception.common.until.ResultUntil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * 全局统一异常处理
 * @author LiQiuShui
 */
@ControllerAdvice(basePackages = "cn.emam.study")
public class GlobalExceptionHandler implements ResponseBodyAdvice {

    private final static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 自定义业务异常
     * @param request http请求
     * @param e 自定义异常
     * @return Result
     */
    @ExceptionHandler(value = ExceptionHandle.class)
    @ResponseBody
    public Result customExceptionHandler(HttpServletRequest request, ExceptionHandle e) {
        logger.error("业务异常：", e);
        return ResultUntil.error(e.getCode(), e.getMsg());
    }

    /**
     * 处理空指针异常
     * @param request http请求
     * @param e 空指针
     * @return Result
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public Result nullPointerHandler(HttpServletRequest request, NullPointerException e) {
        logger.error("发生空指针异常", e);
        return ResultUntil.error(CommonError.BODY_NOT_MATCH);
    }

    /**
     * 处理其他异常
     * @param request http请求
     * @param e 其他异常
     * @return Result
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result exceptionHandler(HttpServletRequest request, Exception e) {
        logger.error("未知异常：", e);
        return ResultUntil.error(CommonError.INTERNAL_SERVER_ERROR);
    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof String) {
            return new Gson().toJson(ResultUntil.success(body));
        } else if (body instanceof Result){
            return body;
        } else {
            return ResultUntil.success(body);
        }
    }
}
