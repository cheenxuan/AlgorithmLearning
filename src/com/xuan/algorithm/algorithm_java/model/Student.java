package com.xuan.algorithm.algorithm_java.model;

public class Student implements Comparable<Student> {
    private String name;
    private int stuNo;

    public int getStuNo() {
        return stuNo;
    }

    public void setStuNo(int stuNo) {
        this.stuNo = stuNo;
    }

    public Student(String name, int stuNo) {
        this.name = name;
        this.stuNo = stuNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 重写父类equal 实现自定义类比较
     *
     * @param student
     * @return
     */
    @Override
    public boolean equals(Object student) {
        if (this == student) return true;
        if (student == null) return false;
        if (this.getClass() != student.getClass()) return false;

        Student temp = (Student) student;
        return name.toLowerCase().equals(temp.name.toLowerCase()) && stuNo == temp.stuNo;
    }

    @Override
    public int compareTo(Student another) {
//        if (this.stuNo < another.stuNo)
//            return -1;
//        else if (this.stuNo == another.stuNo)
//            return 0;
//        return 1;
        return this.stuNo - another.stuNo;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, stuNo: %d)", name, stuNo);
    }
}
