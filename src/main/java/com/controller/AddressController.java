package com.controller;

import com.entity.SellerAddress;
import com.service.AddressService;
import com.service.SellerAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.entity.Address;

import java.util.List;


/*
 * author:@洪伟
 *
 *
 *
 * */
@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired(required = false)
    private AddressService addressService;

    @Autowired(required = false)
    private SellerAddressService sellerAddressService;

    @RequestMapping("/userAddress")
    public List<Address> userAddress(Integer userid){
        List<Address> addressList = addressService.selectByUserId(userid);
        return addressList;
    }

    @RequestMapping("/sellerAddress")
    public List<SellerAddress> sellerAddresses(Integer sellerid){
        List<SellerAddress> sellerAddressList = sellerAddressService.selectByUserId(sellerid);
        return sellerAddressList;
    }
}
