package com.myapp.restapi.client.impl;

import com.myapp.restapi.client.ProductInfoAPI;
import com.myapp.restapi.model.ProductDetail;
import com.myapp.restapi.model.SimilarProducts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class ProductInfoAPIImpl implements ProductInfoAPI {

    @Value("${productsinfoapi}")
    private String productsInfoApi;

    @Override
    public SimilarProducts getSimilarProduct(String productId) {

        var productsApi = productsInfoApi + "/product/" + productId + "/similarids";

        var restTemplate = new RestTemplate();
        var response = restTemplate.getForObject(productsApi, String[].class);

        var similarProducts = new SimilarProducts();
        similarProducts.setProductIds(Arrays.asList(response));
        return similarProducts;
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
