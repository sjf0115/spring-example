package com.spring.example.bean;

/**
 * 功能：POJO Address
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/6/27 08:34
 */
public class Address {
    private String prov;
    private String city;

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "prov='" + prov + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
