package com.zkz.microservice.tools;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zkz.microservice.entity.Product;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Map;


/**
 * @author : Jason Zhuang
 * @date : 22/1/2022
 * @description :
 * @Reference: https://www.baeldung.com/jackson-object-mapper-tutorial
 */
@Slf4j
public class JacksonHandler {

    public static void main(String[] args) {

    }

    private void deserialize_JSON_To_JavaObject() throws JsonProcessingException {
        String json = "{ \"name\" : \"Orange\", \"price\" : \"321.54\" , \"count\" : \"200\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = objectMapper.readValue(json, Product.class);
        System.out.println(product.toString());
    }

    private void serialize_JavaObject_To_JSON() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Product product = new Product("Apple", 123.45d, 100);
        objectMapper.writeValue(new File("target/product.json"), product);
        log.info(product.toString());
    }

    private void JSON_To_JsonNode() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = objectMapper.readTree(json);
        String color = jsonNode.get("color").asText();
        log.info(color);
    }

    private void JSONArray_To_JavaList() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        Map<String, Object> map = objectMapper.readValue(json, new TypeReference<Map<String,Object>>(){});
        log.info(map.toString());
    }


}
