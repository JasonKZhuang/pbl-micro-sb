package com.zkz.microservice.exception;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Jason Zhuang
 * @created 2024.03.21 19:01
 * @project SpringbootMicroservicesTemplate
 * @description:
 */
@RequiredArgsConstructor
@Getter
public class ErrorMessage {
    private final int error_code;
    private final String error_message;
}
