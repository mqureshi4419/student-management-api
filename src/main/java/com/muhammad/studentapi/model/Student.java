package com.muhammad.studentapi.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

import java.util.List;

@Document(collection = "students")
public class Student {
    @Id
    private String mangoId;
    @Field("id")
    private int id;
    private String name;
    private int age;
    private String major;
    private List<String> courseIds;

    public Student(int id, String name, int age, String major, List<String> courseIds) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.major = major;
        this.courseIds = courseIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public List<String> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<String> courseIds) {
        this.courseIds = courseIds;
    }
}
