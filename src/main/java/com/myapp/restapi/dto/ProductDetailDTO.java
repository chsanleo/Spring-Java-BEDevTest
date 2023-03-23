package com.myapp.restapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@AllArgsConstructor
@Data
public class ProductDetailDTO {

    @NonNull
    private String productId;
    @NonNull
    private String name;
    @NonNull
    private Float price;
    @NonNull
    private Boolean availability;
}
