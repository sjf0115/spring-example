package com.spring.example.domain;

public class Book3 {
    private Integer id;
    private String type;
    private String name;

    public Book3() {
    }

    public Book3(String type, Integer id) {
        System.out.println("调用构造器 public Book3(String type, Integer id)");
        this.id = id;
        this.type = type;
    }

    public Book3(Integer id, String name) {
        System.out.println("调用构造器 public Book3(Integer id, String name)");
        this.id = id;
        this.name = name;
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
