package com.myapp.restapi.service;

import com.myapp.restapi.dto.ProductDetailDTO;

import java.util.List;

public interface ProductService {

    List<ProductDetailDTO> similarTo(String productId);
}
