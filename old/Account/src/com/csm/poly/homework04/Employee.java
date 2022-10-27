package com.csm.poly.homework04;

public class Employee {
    private String name;
    private double salary;
    private int workDays;
    private double level;

    public Employee(String name, double salary, int workDays, double level) {
        this.name = name;
        this.salary = salary;
        this.workDays = workDays;
        this.level = level;
    }

    public void printSalary() {
        System.out.print("name:" + name + "\t" + "薪水:" + salary + "\t" + "工作天数:" + workDays + "\t" + "薪水等级：" + level);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getWorkDays() {
        return workDays;
    }

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }
}
