package com.xuan.algorithm.algorithm_java.model;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public boolean equals(Object student) {
        if (this == student) return true;
        if (student == null) return false;
        if (this.getClass() != student.getClass()) return false;

        Student temp = (Student) student;
        return name.toLowerCase().equals(temp.name.toLowerCase()) && age == temp.age;
    }
}
