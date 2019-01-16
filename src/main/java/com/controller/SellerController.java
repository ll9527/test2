package com.controller;

import com.entity.Seller;
import com.entity.SellerBcImg;
import com.entity.User;
import com.service.SellerBcImgService;
import com.service.SellerService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/seller")
public class SellerController {
    @Autowired(required = false)
    private SellerService sellerService;
    @Autowired(required = false)
    private UserService userService;
    @Autowired(required = false)
    private SellerBcImgService sellerBcImgService;

    //商户注册
    @RequestMapping(value = "/sellerRegister")
    public Map sellerRegister(Seller seller, SellerBcImg sellerBcImg, Integer userid) {
        Map<String, Object> map = new HashMap<>();
        //查询User信息并修改is_seller字段
        User user = userService.selectByPrimaryKey(userid);
        if (user.getIsSeller() == 0) {
            user.setIsSeller(1);
            int isOk = userService.updateByPrimaryKeySelective(user);
            if (isOk > 0) {
                //插入Seller数据
                seller.setUserId(userid);
                int isOk2 = sellerService.insertSelective(seller);
                if (isOk2 > 0) {
                    sellerBcImg.setSellerId(userid);
                    int isOk3 = sellerBcImgService.insertSelective(sellerBcImg);
                    if (isOk3 > 0) {
                        map.put("status", "ok");
                        map.put("info", 1);
                    } else {
                        map.put("status", "no");
                        map.put("info", -1);
                    }
                } else {
                    map.put("status", "no");
                    map.put("info", -1);
                }
            } else {
                map.put("status", "no");
                map.put("info", -1);
            }
        } else if(user.getIsSeller() == 1){
            map.put("status", "no");
            map.put("info", -9);//-9为已是商家，不予重新注册
        }
        return map;
    }
}
