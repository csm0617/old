package com.csm.dao_.domian;

import java.util.Date;

/**
 * @Author 快乐小柴
 * @Date 2022/9/23 11:06
 * @Version 1.0
 */
public class Actor {
    private int id;
    private String name;
    private Date birthday;
    private String phone;
    public Actor() {
    }

    public Actor(int id, String name, Date birthday, String phone) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Actor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", phone='" + phone + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
