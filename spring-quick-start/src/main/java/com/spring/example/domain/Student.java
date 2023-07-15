package com.spring.example.domain;

/**
 * 功能：POJO Student
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/6/27 08:25
 */
public class Student {
    private int id;
    private String name;
    private Book book;

    public Student() {
    }

    public Student(int id, String name, Book book) {
        System.out.println("调用 Student(int id, String name, Book book)");
        this.id = id;
        this.name = name;
        this.book = book;
    }

    public Student(Book book) {
        System.out.println("调用 Student(Book book)");
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("调用 Student#setId(int id)");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 Student#setName(String name)");
        this.name = name;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        System.out.println("调用 Student#setBook(Book book)");
        this.book = book;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
