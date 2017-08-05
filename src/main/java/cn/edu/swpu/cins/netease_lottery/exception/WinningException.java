package cn.edu.swpu.cins.netease_lottery.exception;

/**
 * Created by miaomiao on 17-8-2.
 */
public class WinningException extends LotteryException{

    public WinningException() {
        super();
    }

    public WinningException(String message) {
        super(message);
    }

    public WinningException(String message, Throwable cause) {
        super(message, cause);
    }

    public WinningException(Throwable cause) {
        super(cause);
    }

    protected WinningException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
