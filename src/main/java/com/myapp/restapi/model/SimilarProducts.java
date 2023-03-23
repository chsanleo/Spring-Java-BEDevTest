package com.myapp.restapi.model;

import lombok.Data;

import java.util.List;

@Data
public class SimilarProducts {
    private List<String> productIds;
}
