package com.myapp.restapi.model;

import lombok.*;

@EqualsAndHashCode
@NoArgsConstructor
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
