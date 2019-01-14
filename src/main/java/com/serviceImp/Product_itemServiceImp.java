package com.serviceImp;

import com.dao.Product_itemMapper;
import com.entity.Product_item;
import com.service.Product_itemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Product_itemServiceImp implements Product_itemService {

    @Autowired(required = false)
    private Product_itemMapper productItemMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return productItemMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Product_item record) {
        return productItemMapper.insert(record);
    }

    @Override
    public int insertSelective(Product_item record) {
        return productItemMapper.insertSelective(record);
    }

    @Override
    public Product_item selectByPrimaryKey(Integer id) {
        return productItemMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Product_item record) {
        return productItemMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Product_item record) {
        return productItemMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<Product_item> selectAll() {
        return productItemMapper.selectAll();
    }


}
