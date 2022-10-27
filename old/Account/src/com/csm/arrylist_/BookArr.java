package com.csm.arrylist_;

import java.util.Arrays;
import java.util.Comparator;

public class BookArr {
    public static void main(String[] args) {
        Book[] books = new Book[5];
        books[0] = new Book("金瓶梅", 50);
        books[1] = new Book("三国演义", 32);
        books[2] = new Book("java从入门到放弃", 68);
        books[3] = new Book("皮卡丘大战卡布达", 10);
        books[4] = new Book("桃之助吃屁", 90);
        Arrays.sort(books, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
//                Book book1 = (Book) o1;
//                Book book2 = (Book) o2;
//                return book1.getPrice() - book2.getPrice();
                Book book1 = (Book) o1;
                Book book2 = (Book) o2;
                return book2.getName().length() - book1.getName().length();
            }
        });
        System.out.println(Arrays.toString(books));

    }

    public static void bookPriceSort(Book[] books, Comparator c) {
        Book temp = null;
        for (int i = 0; i < books.length; i++) {
            for (int j = 0; j < books.length - i - 1; j++) {
                if (c.compare(books[j], books[j + 1]) > 0) {
                    temp = books[j];
                    books[j] = books[j + 1];
                    books[j + 1] = temp;
                }
            }
        }
    }

}

class Book {
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "书名:" + name + "   " + "price:" + price;
    }
}