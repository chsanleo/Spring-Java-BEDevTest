package com.myapp.restapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.restapi.client.ProductInfoAPI;
import com.myapp.restapi.dto.ProductDetailDTO;
import com.myapp.restapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoAPI api;

    @Override
    public List<ProductDetailDTO> similarTo(String productId) {
        var similarProducts = api.getSimilarProduct(productId);

        var productDetailList = new ArrayList<ProductDetailDTO>();

        for (var productIdApi : similarProducts.getProductIds()) {
            var productDetail = new ObjectMapper().convertValue(api.getProduct(productIdApi),
                    ProductDetailDTO.class);
            if (productDetail != null) {
                productDetailList.add(productDetail);
            }
        }
        return productDetailList;
    }
}
