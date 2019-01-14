package com.controller;

import com.entity.Product_item;
import com.service.Product_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Product")
public class Product_itemController {

    @Autowired
    private Product_itemService productItemService;

    @RequestMapping("/selectAll")
    public List<Product_item> selectAll(){
        return  productItemService.selectAll();
    }
}
