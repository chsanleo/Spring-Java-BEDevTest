package com.myapp.restapi.dto;

import lombok.Data;

import java.util.List;

@Data
public class SimilarProductsDTO {
    private List<ProductDetailDTO> productDetailDTOList;
}
