package com.myapp.restapi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.myapp.restapi.client.ProductInfoAPI;
import com.myapp.restapi.dto.ProductDetailDTO;
import com.myapp.restapi.exceptions.FormatNotValidException;
import com.myapp.restapi.exceptions.ProductNotFoundException;
import com.myapp.restapi.service.ProductService;
import io.micrometer.common.util.StringUtils;
import io.netty.util.internal.StringUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductInfoAPI api;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<ProductDetailDTO> similarTo(String productId) throws ProductNotFoundException, FormatNotValidException {

        validateProductId(productId);

        var similarProducts = api.getSimilarProduct(productId);

        if (CollectionUtils.isEmpty(similarProducts)){
           throw new ProductNotFoundException("Not found for productId: "+ productId);
        }

        return similarProducts.stream()
                .map(api::getProduct)
                .filter(Objects::nonNull)
                .map(productDetail -> objectMapper.convertValue(productDetail, ProductDetailDTO.class))
                .collect(Collectors.toList());
    }

    private void validateProductId(String productId) throws FormatNotValidException {
        if(StringUtils.isBlank(productId)){
            throw new FormatNotValidException("Formar not valid of: "+ productId);
        }
    }
}
