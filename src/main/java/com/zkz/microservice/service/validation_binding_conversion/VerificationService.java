package com.zkz.microservice.service.validation_binding_conversion;

import com.zkz.microservice.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Jason Zhuang
 * @created 2024.03.21 18:21
 * @project SpringbootMicroservicesTemplate
 * @description:
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class VerificationService {

    public long convertStringToLong(String arg) {
        long v = 0;
        if (arg == null || arg.isEmpty()) {
            throw new BadRequestException(String.format("{%s} is not a valid number.", arg));
        }
        try {
            return Long.parseLong(arg);
        } catch (NumberFormatException nfe) {
            throw new BadRequestException(String.format("[%s] is not a valid number.", arg));
        }
    }

}
