package com.zkz.microservice.dto;

import lombok.Data;

/**
 * @author Jason Zhuang
 * @created 2024.03.24 13:35
 * @project SpringbootMicroservicesTemplate
 * @description:
 */
@Data
public class Customer {
    private String firstName;
    private String lastName;
    private Address address;
}
