package com.xxa.exception;
/**
 * 重复预约异常
 * @author xiaoxiai
 */
public class RepeatAppointException extends RuntimeException {
	
    public RepeatAppointException(String message) {
        super(message);
    }

    public RepeatAppointException(String message, Throwable cause) {
        super(message, cause);
    }
}
