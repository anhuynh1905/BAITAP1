package com.ltdd.baitap241.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse <T> {
    private int code;
    private String message;
    private T result;
}
