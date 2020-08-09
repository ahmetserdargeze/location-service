package com.ahmetserdargeze.migrosassesment.solution1.model.response;

import org.springframework.http.HttpStatus;

public class BaseResponse {
    private HttpStatus httpStatus;
    private String operationMessage;
    private boolean success;
    public BaseResponse(HttpStatus httpStatus, String operationMessage, boolean success) {
        this.httpStatus = httpStatus;
        this.operationMessage = operationMessage;
        this.success = success;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getOperationMessage() {
        return operationMessage;
    }

    public void setOperationMessage(String operationMessage) {
        this.operationMessage = operationMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
