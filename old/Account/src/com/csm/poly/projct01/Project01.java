package com.csm.poly.projct01;

public class Project01 {
    public static void main(String[] args) {
        Person[] person = new Person[3];
        person[0] = new Person("smith", 20, "保洁");
        person[1] = new Person("kris", 18, "监狱");
        person[2] = new Person("milan", 28, "java开发");
        BubbleSort(person);
        printArr(person);
    }

    public static Person BubbleSort(Person[] person) {
        Person temp = null;
        for (int i = 0; i < person.length-1; i++) {
            for (int j = 0; j < person.length - i - 1; j++) {
                if (person[i].getAge() > person[i + 1].getAge()) {
                    temp = person[i];
                    person[i] = person[i + 1];
                    person[i + 1] = temp;
                }
            }
        }
        Person sort = person[0];
        return sort;
    }

    public static void printArr(Person[] person) {
        for (int i = 0; i < person.length; i++) {
//            System.out.println("姓名：\t"+person[i].getName()+"\t"+"年龄：\t"+person[i].getAge()+"\t"+"工作：\t"+person[i].getJob());
//              System.out.println(person[i].toString());
            System.out.println(person[i]);//默认调用toString方法
        }
    }
}

