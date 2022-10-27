package com.csm.poly.homework13;

public class Homework13 {
    public static void main(String[] args) {
        Person[] people = new Person[4];
        people[0] = new Student("smith", 15, '男', "1800300913");
        people[1] = new Student("milan", 18, '女', "1800300102");
        people[2] = new Teacher("李老师", 30, '男', 8);
        people[3] = new Teacher("王老师", 25, '女', 3);
        bubbleSortAge(people);
        printArrInfo(people);
    }

    public static void bubbleSortAge(Person[] people) {
        Person temp = null;
        for (int i = 0; i < people.length - 1; i++) {
            for (int j = 0; j < people.length - 1 - i; j++) {
                if (people[j].getAge() < people[j + 1].getAge()) {
                    temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    public static void printArrInfo(Person[] people) {
        for (int i = 0; i < people.length; i++) {
            System.out.println(people[i]);
            if (people[i] instanceof Student) {
                Student student = (Student) people[i];
                student.study();
            } else if (people[i] instanceof Teacher) {
                Teacher teacher = (Teacher) people[i];
                teacher.teach();
            }
            System.out.println(people[i].play() + "\n");
        }
    }
}