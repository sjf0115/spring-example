package com.spring.example.domain;

import org.springframework.stereotype.Component;

/**
 * 功能：员工
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/16 07:44
 */
@Component("employee")
public class Employee {
    private int id;
    private String name;

    public Employee() {
        System.out.println("调用 Employee#Employee()");
    }

    public Employee(int id, String name) {
        System.out.println("调用 Employee#Employee(int id, String name)");
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("调用 Employee#setId(int id)");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 Employee#setName(String name)");
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
