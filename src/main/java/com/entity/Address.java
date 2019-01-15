package com.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
public class Address {
    private Integer id;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
}