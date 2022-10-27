package com.csm.extend_01;

public class Base {//父类
    public int n1 = 100;
    protected int n2 = 200;
    int n3 = 300;
    private int n4 = 400;
    public Base(){
        System.out.println("Base()父类无参构造器被调用");
    }
    public Base(String name ,int age){
        System.out.println("父类Base(String name ,int age)构造器被调用");

    }
    public Base(String name){
        System.out.println("父类Base(String name)被调用");
    }
    public int getN4(){//提供公有方法调用私有变量n4
        return n4;
    }
    public void test100(){
        System.out.println("test100()调用");
    }
    protected void test200(){
        System.out.println("test200()调用");
    }
    void test300(){
        System.out.println("test300()调用");
    }
    private void test400(){
        System.out.println("test400()调用");
    }
    public void callTest400(){//提供公开方法供子类调用test400
        test400();
    }
}
