package com.tp.notification.exception;

public class NotificationException extends Exception {
    public NotificationException(String message) {
        super(message);
    }

    public NotificationException(Throwable cause) {
        super(cause);
    }

    public NotificationException(String message, Throwable cause) {
        super(message, cause);
    }
}
