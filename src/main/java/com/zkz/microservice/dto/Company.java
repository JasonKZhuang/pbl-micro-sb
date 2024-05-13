package com.zkz.microservice.dto;

import lombok.Data;

@Data
public class Company {
	private String name;
	private Employee managingDirector;
}