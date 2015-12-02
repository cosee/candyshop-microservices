package biz.cosee.exception;

/**
 * Created by kroehan on 26.11.15.
 */
public class CandyNotFoundException extends  RuntimeException {
    public CandyNotFoundException(String s) {
        super(s);
    }
}
