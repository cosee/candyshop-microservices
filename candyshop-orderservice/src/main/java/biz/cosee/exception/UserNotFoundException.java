package biz.cosee.exception;

/**
 * Created by kroehan on 26.11.15.
 */
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String s) {
        super(s);
    }
}
