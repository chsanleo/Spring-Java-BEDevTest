package com.myapp.restapi.client.impl;

import com.myapp.restapi.client.ProductInfoAPI;
import com.myapp.restapi.exceptions.ProductNotFoundException;
import com.myapp.restapi.model.ProductDetail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductInfoAPIImpl implements ProductInfoAPI {

    @Value("${productsinfoapi}")
    private String productsInfoApi;

    @Override
    public List<String> getSimilarProduct(String productId) throws ProductNotFoundException {

        var productsApi = productsInfoApi + "/product/" + productId + "/similarids";

        var restTemplate = new RestTemplate();
        try {
            var response = restTemplate.getForObject(productsApi, String[].class);
            return Arrays.asList(response);
        } catch (HttpClientErrorException ex) {
            throw new ProductNotFoundException(ex.getMessage());
        }
    }

    @Override
    public ProductDetail getProduct(String productId) {
        var productDetailApi = productsInfoApi + "/product/" + productId;

        try {
            var restTemplate = new RestTemplate();
            var productDetail = restTemplate.getForObject(productDetailApi, ProductDetail.class);
            return productDetail;
        } catch (Exception ex) {
            return null;
        }

    }
}
