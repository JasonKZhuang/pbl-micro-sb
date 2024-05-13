package com.zkz.microservice.repository;

import com.zkz.microservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Jason Zhuang on 17/11/21.
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

}