package com.csm.poly.homework13;

public class Student extends Person {
    private String stu_id;

    public Student(String name, int age, char sex, String stu_id) {
        super(name, age, sex);
        this.stu_id = stu_id;
    }

    public void study(){
        System.out.println("我承诺，我会好好学习");
    }

    @Override
    public String play() {

        return super.play()+"爱踢足球";
    }

    @Override
    public String toString() {
        return super.toString() +
                "学号：" + stu_id ;
    }

    public String getStu_id() {
        return stu_id;
    }

    public void setStu_id(String stu_id) {
        this.stu_id = stu_id;
    }
}
