package com.spring.example.domain;

// 用来测试构造器注入 - name 属性
public class Book2 {
    private Integer id;
    private String type;
    private String name;

    public Book2() {
    }

    public Book2(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Book2(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
