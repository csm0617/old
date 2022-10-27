package com.csm.poly.homework10;

public class Test {
    public static void main(String[] args) {
        Doctor doctor01 = new Doctor("smith", 20, "医学博士", '男', 5000);
        Doctor doctor02 = new Doctor("smith", 20, "医学博士", '男', 5000);
        System.out.println(doctor01.equals(doctor02));;
//        System.out.println(doctor01);
//        System.out.println(doctor01 instanceof Doctor);
    }

}
