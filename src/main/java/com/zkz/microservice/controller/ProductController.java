package com.zkz.microservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkz.microservice.dto.ResponseDTO;
import com.zkz.microservice.entity.Product;
import com.zkz.microservice.exception.ProductNotFoundException;
import com.zkz.microservice.repository.ProductRepository;
import com.zkz.microservice.service.AuthenticationService;
import com.zkz.microservice.service.ProductService;
import com.zkz.microservice.service.validation_binding_conversion.VerificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jason Zhuang 17/11/2021
 */
@Slf4j
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController {
    private final AuthenticationService authenticationService;
    private final VerificationService verificationService;
    private final ProductService productService;
    private final ProductRepository repProduct;

    /**
     * To get all products
     *
     * @return
     */
    @GetMapping("/")
    public List<Product> getAll() {
        // 1. verify authentication
        return repProduct.findAll();
    }

    @GetMapping("/{id}")
    public Product getOne(@PathVariable String id) {
        try {
            // 1. Rate Limiting
            // 2. Authentication
            // 3. Verification for parameters and payload,
            long okId = verificationService.convertStringToLong(id);
            // 4. logging for error and important info
            // 5. Error Handling
            // 6. Pagination and Filtering
            // 7. Caching

            return repProduct.findById(okId).orElseThrow(() -> new ProductNotFoundException(okId));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/")
    public Product newProduct(@RequestBody Product newProduct) {
        return repProduct.save(newProduct);
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@RequestBody Product newProduct, @PathVariable Long id) {
        return repProduct.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    return repProduct.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repProduct.save(newProduct);
                });
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repProduct.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/one")
    public ResponseEntity<ResponseDTO> myGetMethod(@RequestParam("id") String productId) {
        log.info("Come into method: {}", "myGetMethod");
        long pId = Long.parseLong(productId);
        Product p;
        ObjectMapper mapper = new ObjectMapper();
        try {
            p = productService.getProductById(pId);
            System.out.println(p.toString());
        } catch (Exception e) {
            log.error("something wrong");
        }

        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setMessage("Success!");
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

}
