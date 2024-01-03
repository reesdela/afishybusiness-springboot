package com.fishybusiness.afishybusiness.shared;

import java.util.Map;

import org.springframework.http.HttpStatus;

import lombok.Builder;

@Builder
public class APIResponse<T> {
    private String status;
    private Integer httpStatus;
    private String message;
    private String internalCode;
    private T data;

    public Integer getHttpStatus() {
        return httpStatus;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getInternalCode() {
        return internalCode;
    }

    public T getData() {
        return data;
    }

    public static <T> APIResponse<T> ok(T data, Map<String, String> responseHashMap, String key) {
        return APIResponse.<T>builder().httpStatus(HttpStatus.OK.value())
                .status(Constant.RESULT_OK)
                .message(responseHashMap.get(key))
                .internalCode(key)
                .data(data)
                .build();
    }
}
