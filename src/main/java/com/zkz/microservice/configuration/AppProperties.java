package com.zkz.microservice.configuration;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Jason Zhuang on 17/11/21.
 */
@Configuration
@RequiredArgsConstructor
@Data
public class AppProperties {
    // business parts
    @Value("${application.name}")
    private String customizedApplicationName;

    @Value("${application.description}")
    private String customizedApplicationDescription;

    // system parts

    // spring parts
    @Value("${spring.mvc.format.date-time}")
    private String formatDateTime;

}
