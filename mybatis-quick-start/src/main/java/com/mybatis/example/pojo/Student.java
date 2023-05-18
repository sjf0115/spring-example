package com.mybatis.example.pojo;

/**
 * 功能：Student
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/18 下午4:06
 */
public class Student {
    // 自增ID
    private int id;
    // 编码
    private int stuId;
    // 姓名
    private String stuName;
    // 状态
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", status=" + status +
                '}';
    }
}
