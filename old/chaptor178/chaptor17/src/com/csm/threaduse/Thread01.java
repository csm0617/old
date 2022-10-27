package com.csm.threaduse;

/**
 * @Author 快乐小柴
 * @Date 2022/9/8 23:53
 * @Version 1.0
 */
public class Thread01 {
    public static void main(String[] args)throws InterruptedException{
        Cat cat = new Cat();
        cat.start();
        System.out.println("主线程继续执行"+Thread.currentThread().getName());
        for (int i = 0; i < 60; i++) {
            System.out.println("主线程i="+i);
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {
    private int times=0;
    @Override
    public void run() {
        while (true) {
            System.out.println("汪汪，我是一只快乐小柴"+(++times)+Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (times==60)
                break;
        }
    }
}
