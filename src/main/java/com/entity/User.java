package com.entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.math.BigDecimal;

@EntityScan
public class User {
    private Integer id;

    private String username;

    private String password;

    private Integer isVip;

    private Integer isSeller;

    private Long tel;

    private Integer score;

    private BigDecimal money;

    private Integer isAdmin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getIsVip() {
        return isVip;
    }

    public void setIsVip(Integer isVip) {
        this.isVip = isVip;
    }

    public Integer getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(Integer isSeller) {
        this.isSeller = isSeller;
    }

    public Long getTel() {
        return tel;
    }

    public void setTel(Long tel) {
        this.tel = tel;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public Integer getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Integer isAdmin) {
        this.isAdmin = isAdmin;
    }
}