package com.csm.poly.homework10;

import java.util.Objects;

public class Doctor {
    private String name;
    private int age;
    private String job;
    private char gender;
    private double sal;

    public Doctor(String name, int age, String job, char gender, double sal) {
        this.name = name;
        this.age = age;
        this.job = job;
        this.gender = gender;
        this.sal = sal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Doctor doctor = (Doctor) o;
//        return age == doctor.age &&
//                gender == doctor.gender &&
//                Double.compare(doctor.sal, sal) == 0 &&
//                Objects.equals(name, doctor.name) &&
//                Objects.equals(job, doctor.job);
//    }
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Doctor)) return false;
//        if (obj == null || this.getClass() != obj.getClass()) return false;
        Doctor doctor = (Doctor) obj;
        return  this.age == doctor.age &&
                this.sal == doctor.sal &&
                this.name.equals(doctor.name) &&
                this.gender==doctor.gender&&
                this.job.equals(doctor.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, job, gender, sal);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", job='" + job + '\'' +
                ", gender=" + gender +
                ", sal=" + sal +
                '}';
    }
}
