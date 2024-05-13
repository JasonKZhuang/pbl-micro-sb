package com.zkz.microservice.entity;

import jakarta.persistence.*;
import lombok.*;



/**
 * Created by Jason Zhuang on 17/11/21.
 */

@Data
@Entity
@Table(name = "product")
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;
    
    private Double price=0D;

    private Integer count=0;

    public Product(@NonNull String name) {
        this.name = name;
    }

    public Product(@NonNull String name, Double price, Integer count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }
}