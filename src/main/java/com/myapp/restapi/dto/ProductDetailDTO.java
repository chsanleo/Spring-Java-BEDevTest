package com.myapp.restapi.dto;

import lombok.*;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductDetailDTO {

    @NonNull
    private String id;
    @NonNull
    private String name;
    @NonNull
    private Double price;
    @NonNull
    private Boolean availability;
}
