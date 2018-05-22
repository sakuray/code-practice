package com.sakuray.code.practice.jdk.io.entity;

import java.io.Serializable;

public class Teacher implements Serializable {

    private int age;
    private String name;
    private Student student;

    public Teacher(int age, String name, Student student) {
        this.age = age;
        this.name = name;
        this.student = student;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher [age=" + age + ", name=" + name + ", student=" + student + "]";
    }

}
