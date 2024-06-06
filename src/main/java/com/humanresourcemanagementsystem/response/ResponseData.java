package com.humanresourcemanagementsystem.response;

import java.util.Map;

public class ResponseData {
    private Boolean success;
    private String message;
    private Map<String, Object> data;

    public ResponseData(String message, Boolean success, Map<String, Object> data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getsuccess() {
        return success;
    }

    public void setsuccess(Boolean success) {
        this.success = success;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public Boolean isSuccess() {
        return success;
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
