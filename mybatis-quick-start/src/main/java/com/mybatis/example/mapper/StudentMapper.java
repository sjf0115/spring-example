package com.mybatis.example.mapper;

import com.mybatis.example.pojo.Student;
import com.mybatis.example.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能：StudentMapper
 * 作者：SmartSi
 * CSDN博客：https://smartsi.blog.csdn.net/
 * 公众号：大数据生态
 * 日期：2023/5/17 上午12:09
 */
public interface StudentMapper {
    // 查询
    List<Student> selectAll();
    Student selectById(@Param("stu_id") int id);
    // 插入
    void addStudent(Student stu);
    // 批量插入
    void addStudents(List<Student> students);
    // 更新
    int updateStudent(Student stu);
    // 删除指定学生
    int deleteStudentById(int id);
    // 批量删除学生
    int deleteStudentByIds(@Param("ids") List<Integer> ids);
}
