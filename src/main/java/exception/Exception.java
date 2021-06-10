package exception;

/**
 * @Author: zhengyi
 * @Date: 2021/6/10 18:49
 * @Description:异常代码
 */
public class Exception extends RuntimeException {
    private String code;

    public Exception(String code, String message, Throwable cause){
        super(message, cause);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
