package com.csm.poly.homework13;

public class Teacher extends Person{
    private double work_age;

    public Teacher(String name, int age, char sex, double work_age) {
        super(name, age, sex);
        this.work_age = work_age;
    }

    public void teach(){
        System.out.println("我承诺，我会好好教学");
    }

    @Override
    public String play() {
        return super.play()+"爱玩象棋";
    }

    @Override
    public String toString() {
        return super.toString() +
                "工龄：" + work_age ;
    }

    public double getWork_age() {
        return work_age;
    }

    public void setWork_age(double work_age) {
        this.work_age = work_age;
    }
}
