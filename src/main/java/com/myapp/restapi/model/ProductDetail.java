package com.myapp.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;

@EqualsAndHashCode
@AllArgsConstructor
@Data
public class ProductDetail {

    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private Boolean availability;
}
