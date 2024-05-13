package com.zkz.microservice.dto;

import lombok.Data;

/**
 * @author Jason Zhuang
 * @created 2024.03.24 13:36
 * @project SpringbootMicroservicesTemplate
 * @description:
 */
@Data
public class Address {
    private String unit;
    private String number;
    private String street;
    private String suburb;
    private String city;
    private String state;
    private String country;
}
