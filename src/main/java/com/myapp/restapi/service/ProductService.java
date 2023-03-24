package com.myapp.restapi.service;

import com.myapp.restapi.dto.ProductDetailDTO;
import com.myapp.restapi.exceptions.FormatNotValidException;
import com.myapp.restapi.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {

    List<ProductDetailDTO> similarTo(String productId) throws ProductNotFoundException, FormatNotValidException;
}
