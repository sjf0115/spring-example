package com.spring.example.domain;

public class Book {
    private Integer id;
    private String type;
    private String name;

    public Book() {
    }

    public Book(Integer id, String type, String name) {
        this.id = id;
        this.type = type;
        this.name = name;
    }

    public Book(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public Book(String type, Integer id) {
        this.id = id;
        this.type = type;
    }

    public Book(Integer id, String name) {
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
