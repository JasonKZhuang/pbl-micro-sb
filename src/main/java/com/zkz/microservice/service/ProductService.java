package com.zkz.microservice.service;

import com.zkz.microservice.entity.Product;
import com.zkz.microservice.entity.User;
import com.zkz.microservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Created by Jason Zhuang on 17/11/21.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductService {

    private final Log apacheLog = LogFactory.getLog(getClass());

    // inject RestTemplate, so we can call another api endpoints which are outside this service
    // @Autowired
    // private RestTemplate restTemplate;

    private final ProductRepository repProduct;

    public List<Product> getProducts() {
        return repProduct.findAll();
    }

    public Product getProductById(long id) {
        Product retValue = new Product();
        retValue = repProduct.findById(id).orElse(null);
        return retValue;
    }

    // using RestTemplate to call the other endpoint which is outside this service,
    // communicating with other microservice
    public User callOutsideEndpoint(String userId){
        String myUrl = "https://localhost:8093/users" + userId;
        //User u = restTemplate.getForObject(myUrl, User.class);
        return new User();
    }
}
