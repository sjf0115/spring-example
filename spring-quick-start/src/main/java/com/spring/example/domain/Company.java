package com.spring.example.domain;

/**
 * 功能：公司
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/7/16 07:43
 */
public class Company {
    private int id;
    private String name;
    private Employee employee;

    public Company() {
        System.out.println("调用 Company#Company()");
    }

    public Company(int id, String name, Employee employee) {
        System.out.println("调用 Company#Company(int id, String name, Employee employee)");
        this.id = id;
        this.name = name;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        System.out.println("调用 Company#setId(int id)");
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("调用 Company#setName(String name)");
        this.name = name;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        System.out.println("调用 Company#setEmployee(Employee employee)");
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", employee=" + employee +
                '}';
    }
}
