package com.example.demo.exception;

import java.time.LocalDateTime;

public class ErrorResponse {
	private String error;
    private String message;
    private LocalDateTime timestamp;
	public ErrorResponse(String error, String message, LocalDateTime timestamp) {
		super();
		this.error = error;
		this.message = message;
		this.timestamp = timestamp;
	}
	public String getError() {
		return error;
	}
	public String getMessage() {
		return message;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	@Override
	public String toString() {
		return "ErrorResponse [error=" + error + ", message=" + message + ", timestamp=" + timestamp + "]";
	}
	
}
