package com.csm.account;

public class Account {
    private String name;
    private double salary;
    private String pwd;
    //提供两个构造器

    public Account(String name) {
    }

    public Account(String name, double salary, String pwd) {
        this.setName(name);
        this.setSalary(salary);
        this.setPwd(pwd);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() >= 2 && name.length() <= 4) {
            this.name = name;
        } else {
            System.out.println("姓名要求2到4个字符，默认值“无名”");
            this.name = "无名";
        }

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary > 60) {
            this.salary = salary;
        } else {
            System.out.println("薪水的必须大于60，否则给默认值0");
            this.salary = 0;
        }
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        if (pwd.length() == 6) {
            this.pwd = pwd;
        } else {
            System.out.println("密码必须是6位,否则给默认名值123456");
            this.pwd = "123456";

        }
    }

    public void showInfo() {
        System.out.println("姓名:" + name + "\t薪水:" + salary + "\t密码:" + pwd);
    }
}
