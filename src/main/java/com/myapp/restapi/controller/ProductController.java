package com.myapp.restapi.controller;

import com.myapp.restapi.dto.ProductDetailDTO;
import com.myapp.restapi.exceptions.FormatNotValidException;
import com.myapp.restapi.exceptions.ProductNotFoundException;
import com.myapp.restapi.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {

    private final ProductService service;

    @GetMapping("/{productId}/similar")
    public ResponseEntity<List<ProductDetailDTO>> similarTo(@PathVariable String productId) {
        try {
            var result = service.similarTo(productId);
            return new ResponseEntity<>(result, HttpStatus.OK);

        } catch (ProductNotFoundException ex){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (FormatNotValidException ex){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
