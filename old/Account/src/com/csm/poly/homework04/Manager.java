package com.csm.poly.homework04;

public class Manager extends Employee {
    private double money;

    public Manager(String name, double salary, int workDays, double level, double money) {
        super(name, salary, workDays, level);
        this.money += salary * workDays * level;
    }

    @Override
    public void printSalary() {
        super.printSalary();
        System.out.print("\t" + "总工资：" + this.money);
    }
}
