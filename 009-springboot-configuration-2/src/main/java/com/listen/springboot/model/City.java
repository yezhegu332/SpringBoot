package com.listen.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 李松
 * 2020/7/18
 */
@Component
@ConfigurationProperties(prefix = "city")
public class City {
    private String name;
    private String phone;

    public City() {
    }

    public City(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
