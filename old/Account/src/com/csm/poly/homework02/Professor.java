package com.csm.poly.homework02;

public class Professor extends Teacher{
    private double salaryLevel;

    public Professor(String name, int age, String post, double salary, double salaryLevel) {
        super(name, age, post, salary);
        this.salaryLevel = salaryLevel;
        this.setSalary(salary*salaryLevel);
    }

    @Override
    public void introduce() {
        super.introduce();
        System.out.print("\t"+"工资级别:\t"+salaryLevel);
    }
}
