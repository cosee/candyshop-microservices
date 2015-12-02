package biz.cosee.exception;

/**
 * Created by kroehan on 26.11.15.
 */
public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String s) {
        super(s);
    }
}
