package com.listen.springboot.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 李松
 * 2020/7/18
 */
@Component
@ConfigurationProperties(prefix = "school")
public class School {
    private String name;
    private String phone;

    public School() {
    }

    public School(String name, String phone) {
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
        return "School{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
