package com.facebooked.demofacebooded.pojo;

import java.util.List;

public class SuccessResponse {
    private String httpStatusMessage;
    private int httpCode;
    private Object data;
    private List<String> errorValidation;

    // Constructors
    public SuccessResponse() {
    }

    public SuccessResponse(String httpStatusMessage, int httpCode, Object data, List<String> errorValidation) {
        this.httpStatusMessage = httpStatusMessage;
        this.httpCode = httpCode;
        this.data = data;
        this.errorValidation = errorValidation;
    }

    // Getter and Setter methods
    public String getHttpStatusMessage() {
        return httpStatusMessage;
    }

    public void setHttpStatusMessage(String httpStatusMessage) {
        this.httpStatusMessage = httpStatusMessage;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<String> getErrorValidation() {
        return errorValidation;
    }

    public void setErrorValidation(List<String> errorValidation) {
        this.errorValidation = errorValidation;
    }

    @Override
    public String toString() {
        return "SuccessResponse{" +
                "httpStatusMessage='" + httpStatusMessage + '\'' +
                ", httpCode=" + httpCode +
                ", data=" + data +
                ", errorValidation=" + errorValidation +
                '}';
    }
}
