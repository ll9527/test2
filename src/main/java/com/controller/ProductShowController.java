package com.controller;

import com.entity.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/product")
public class ProductShowController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getAll")
    public List<Product> getAll(){
        List<Product> productLsit =  productService.selectAll();
        return productLsit;
    }



}
