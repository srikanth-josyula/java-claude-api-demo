package com.demo.claude.exception;

public class ClaudeApiException extends RuntimeException {

    private static final long serialVersionUID = 1L;

	public ClaudeApiException(String message) {
        super(message);
    }

    public ClaudeApiException(String message, Throwable cause) {
        super(message, cause);
    }
}