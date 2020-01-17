package cn.emam.unifyexception.common.handle;

import cn.emam.unifyexception.common.enums.BaseErrorInterface;
import lombok.Getter;
import lombok.Setter;

/**
 * 统一异常处理Handle
 * @author LiQiuShui
 */
@Setter
@Getter
public class ExceptionHandle extends RuntimeException{
    protected String code;
    protected String msg;

    public ExceptionHandle() {
        super();
    }

    public ExceptionHandle(BaseErrorInterface errorInterface) {
        super(errorInterface.getResultCode());
        this.code = errorInterface.getResultCode();
        this.msg = errorInterface.getResultMsg();
    }

    public ExceptionHandle(BaseErrorInterface errorInterface, Throwable cause) {
        super(errorInterface.getResultCode(), cause);
        this.code = errorInterface.getResultCode();
        this.msg = errorInterface.getResultMsg();
    }

    public ExceptionHandle(String msg) {
        super(msg);
        this.msg = msg;
    }

    public ExceptionHandle(String code, String msg) {
        super(code);
        this.code = code;
        this.msg = msg;
    }

    public ExceptionHandle(String code, String msg, Throwable cause) {
        super(code, cause);
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getMessage() {
       return msg;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
