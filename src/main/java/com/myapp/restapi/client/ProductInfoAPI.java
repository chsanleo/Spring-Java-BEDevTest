package com.myapp.restapi.client;

import com.myapp.restapi.model.ProductDetail;
import com.myapp.restapi.model.SimilarProducts;

public interface ProductInfoAPI {
    SimilarProducts getSimilarProduct(String productId);
    ProductDetail getProduct(String productId);
}
