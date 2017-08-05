package cn.edu.swpu.cins.netease_lottery.exception;

/**
 * Created by miaomiao on 17-8-2.
 */
public class LotteryException extends Exception {
    public LotteryException() {
        super();
    }

    public LotteryException(String message) {
        super(message);
    }

    public LotteryException(String message, Throwable cause) {
        super(message, cause);
    }

    public LotteryException(Throwable cause) {
        super(cause);
    }

    protected LotteryException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
