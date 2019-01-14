package com.service;

import com.entity.Shop_classify;

public interface Shop_classifyService {
    int deleteByPrimaryKey(Integer classId);

    int insert(Shop_classify record);

    int insertSelective(Shop_classify record);

    Shop_classify selectByPrimaryKey(Integer classId);

    int updateByPrimaryKeySelective(Shop_classify record);

    int updateByPrimaryKey(Shop_classify record);
}
