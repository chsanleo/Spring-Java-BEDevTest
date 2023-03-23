package com.myapp.restapi.client;

import com.myapp.restapi.model.ProductDetail;

import java.util.List;

public interface ProductInfoAPI {
    List<String> getSimilarProduct(String productId);

    ProductDetail getProduct(String productId);
}
