package com.listen.springboot.domain;

/**
 * @Author: Listen
 * @Date: 2020/7/23
 */
public class User {
    private Integer id;
    private String name;
    private Integer phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
