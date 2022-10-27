package com.csm.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Collection_ {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        Collection col = new ArrayList();
        col.add(new BOOK("西游记",50,"吴承恩"));
        col.add(new BOOK("水浒传",20,"罗贯中"));
        col.add(new BOOK("红楼梦",80,"曹雪芹"));
        col.add(new BOOK("三国志",100,"陈寿"));
        col.add("jack");//add的构造器参数可以是Object类

//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            Object obj = iterator.next();
//            System.out.println("book:" + obj);
//        }
//
//        Iterator iterator = col.iterator();
//        while (iterator.hasNext()) {
//            System.out.println("book:" + iterator.next());
//        }
//        for (Object books :col) {
//            System.out.println("book"+books);
//        }

    }
}
@SuppressWarnings("all")
class BOOK{
    private String name;
    private double price;
    private String author;

    public BOOK(String name, double price, String author) {
        this.name = name;
        this.price = price;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "BOOK{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}