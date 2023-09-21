package ua.com.alevel.exception;

public class UserExistsException extends RuntimeException {

    public UserExistsException(String msg) {
        super(msg);
    }
}
