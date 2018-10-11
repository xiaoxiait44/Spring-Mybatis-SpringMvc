package com.xxa.exception;
/**
 * 预约业务异常
 * @author xiaoxiai
 */
public class AppointException extends RuntimeException  {
	  public AppointException(String message) {
	        super(message);
	    }
	    public AppointException(String message, Throwable cause) {
	        super(message, cause);
	    }
}
