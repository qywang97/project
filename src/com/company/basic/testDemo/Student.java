package com.company.basic.testDemo;

import java.util.Objects;

public class Student {
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }
    @Override
    public int hashCode() {
       /*
            1、重写hashcode，不重写则会调用顶层父类的hashCode，那么两个对象仅仅是两个没有任何共同之处的对象，hashCode返回的是两个看起来随机的整数，违背相同的对象有相同的hash值原则
            2、
       */
        return Objects.hash(age, name);
    }
    public static void main(String[] args) {
        Student s1 = new Student(19,"ZZY");
        Student s2 = new Student(19,"ZZY");
        System.out.println(s1.equals(s2));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}

