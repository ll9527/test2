package com.service;

import com.entity.Product_item;

import java.util.List;

public interface Product_itemService {
    int deleteByPrimaryKey(Integer id);

    int insert(Product_item record);

    int insertSelective(Product_item record);

    Product_item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Product_item record);

    int updateByPrimaryKey(Product_item record);

    List<Product_item> selectAll();
}
