package com.csm.set_;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.*;

public class homework {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        Person p1=new Person("csm",20);
        Person p2=new Person("dlm",18);
        set.add(p1);
        set.add(p2);
        p1.name="sss";
        System.out.println(set.remove(p1));
        System.out.println(set);
        set.add(new Person("sss",20));
        System.out.println(set);
    }

}
class Person{
    public String name;
    public int age;

    public Person(String name, int age) {
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}