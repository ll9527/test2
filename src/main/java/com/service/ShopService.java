package com.service;

import com.entity.Shop;

public interface ShopService {
    int deleteByPrimaryKey(Integer classId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);
}
